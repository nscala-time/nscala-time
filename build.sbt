organization := "com.github.nscala-time"

name := "nscala-time"

version := "0.7.0-SNAPSHOT"

publishMavenStyle := true

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.9.3", "2.10.3")

scalacOptions <++= scalaVersion map { v =>
  if (v.startsWith("2.10"))
    Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions")
  else
    Seq("-unchecked", "-deprecation")
}

val scaladocBranch = settingKey[String]("branch name for scaladoc -doc-source-url")

scaladocBranch := "master"

scalacOptions in (Compile, doc) ++= { Seq(
  "-sourcepath", baseDirectory.value.getAbsolutePath,
  "-doc-source-url", s"https://github.com/nscala-time/nscala-time/tree/${scaladocBranch.value}€{FILE_PATH}.scala"
)}

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7" % "test",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.2"
)

libraryDependencies <<= (scalaVersion, libraryDependencies) {(version, dependencies) =>
  val specs2 =
    if (version.startsWith("2.10"))
      "org.specs2" %% "specs2" % "1.14" % "test"
    else if (version == "2.9.3")
      "org.specs2" %% "specs2" % "1.12.4.1" % "test"
    else
      "org.specs2" %% "specs2" % "1.12.3" % "test"
    dependencies :+ specs2
}

unmanagedSourceDirectories in Compile <+= (scalaVersion, sourceDirectory in Compile){(v, dir) =>
  if(v.startsWith("2.9"))
    dir / "scala29"
  else
    dir / "scala210"
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

site.settings

site.includeScaladoc()

site.jekyllSupport()

ghpages.settings

git.remoteRepo := "git@github.com:nscala-time/nscala-time.git"
