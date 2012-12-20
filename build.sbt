organization := "com.github.nscala-time"

name := "nscala-time"

version := "0.2.0"

publishMavenStyle := true

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

crossVersion := CrossVersion.full

scalaBinaryVersion <<= scalaBinaryVersion { v =>
  if (v.startsWith("2.10"))
    "2.10"
  else
    v
}

scalacOptions <++= scalaVersion map { v =>
  if (v.startsWith("2.10"))
    Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions")
  else
    Seq("-unchecked", "-deprecation")
}

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

seq(ScctPlugin.instrumentSettings:_*)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7" % "test",
  "joda-time" % "joda-time" % "2.1",
  "org.joda" % "joda-convert" % "1.2"
)

libraryDependencies <<= (scalaVersion, libraryDependencies) {(version, dependencies) =>
  val specs2 =
    if (version.startsWith("2.10"))
      "org.specs2" %% "specs2" % "1.13" % "test"
    else
      "org.specs2" %% "specs2" % "1.12.2" % "test"
  dependencies :+ specs2
}

initialCommands in console += {
  Iterator("org.joda.time._", "com.github.nscala_time.time.Imports._").map("import "+).mkString("\n")
}

pomExtra := (
  <url>https://github.com/nscala-time/nscala-time</url>
  <licenses>
    <license>
      <name>Apache</name>
      <url>http://www.opensource.org/licenses/Apache-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:nscala-time/nscala-time.git</url>
    <connection>scm:git:git@github.com:nscala-time/nscala-time.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kmizu</id>
      <name>Kota Mizushima</name>
      <url>https://github.com/kmizu</url>
    </developer>
  </developers>
)

publishTo <<= version { v =>
  val nexus = "http://oss.sonatype.org/"
  if (v.endsWith("-SNAPSHOT"))
    Some("snapshots" at nexus+"content/repositories/snapshots")
  else
    Some("releases" at nexus+"service/local/staging/deploy/maven2")
}

credentials ++= {
  val sonatype = ("Sonatype Nexus Repository Manager", "oss.sonatype.org")
  def loadMavenCredentials(file: java.io.File) : Seq[Credentials] = {
    xml.XML.loadFile(file) \ "servers" \ "server" map (s => {
      val host = (s \ "id").text
      val realm = if (host == sonatype._2) sonatype._1 else "Unknown"
      Credentials(realm, host, (s \ "username").text, (s \ "password").text)
    })
  }
  val ivyCredentials   = Path.userHome / ".ivy2" / ".credentials"
  val mavenCredentials = Path.userHome / ".m2"   / "settings.xml"
  (ivyCredentials.asFile, mavenCredentials.asFile) match {
    case (ivy, _) if ivy.canRead => Credentials(ivy) :: Nil
    case (_, mvn) if mvn.canRead => loadMavenCredentials(mvn)
    case _ => Nil
  }
}
