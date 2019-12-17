
organization := "com.github.nscala-time"

sonatypeProfileName := "com.github.nscala-time"

name := "nscala-time"

publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

val Scala210 = "2.10.7"

scalaVersion := Scala210

// sbt "release cross"
crossScalaVersions := Seq(Scala210, "2.11.12", "2.12.10", "2.13.1")

val unusedWarnings = "-Ywarn-unused" :: Nil

scalacOptions ++= {
  Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions", "-language:higherKinds", "-Xlint")
}

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v <= 12 => Seq("-Xfuture")
}.toList.flatten

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, scalaMajor)) if scalaMajor >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
)

def gitHashOrBranch: String = scala.util.Try(
  sys.process.Process("git rev-parse HEAD").lines_!.head
).getOrElse("master")

scalacOptions in (Compile, doc) ++= {
  Seq(
    "-sourcepath", baseDirectory.value.getAbsolutePath,
    "-doc-source-url", s"https://github.com/nscala-time/nscala-time/tree/${gitHashOrBranch}€{FILE_PATH}.scala"
  )
}

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.10.5",
  "org.joda" % "joda-convert" % "2.2.1"
)

libraryDependencies ++= {
  Seq("org.scalacheck" %% "scalacheck" % "1.14.3" % "test")
}

pomPostProcess := { node =>
  import scala.xml._
  import scala.xml.transform._
  def stripIf(f: Node => Boolean) = new RewriteRule {
    override def transform(n: Node) =
      if (f(n)) NodeSeq.Empty else n
  }
  val stripTestScope = stripIf { n => n.label == "dependency" && (n \ "scope").text == "test" }
  new RuleTransformer(stripTestScope).transform(node)(0)
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
