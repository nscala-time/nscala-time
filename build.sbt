val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

organization := "com.github.nscala-time"

name := "nscala-time"

publishMavenStyle := true

publishTo := (if (isSnapshot.value) None else localStaging.value)

val Scala211 = "2.11.12"

scalaVersion := Scala211

// sbt "release cross"
crossScalaVersions := Seq(Scala211, "2.12.20", "2.13.16", "3.3.6")

val unusedWarnings = "-Ywarn-unused" :: Nil

scalacOptions ++= {
  Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:implicitConversions,higherKinds",
  )
}

scalacOptions ++= {
  if (isScala3.value) {
    Seq(
    )
  } else {
    Seq(
      "-Xlint"
    )
  }
}

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v <= 12 => Seq("-Xfuture")
}.toList.flatten

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, scalaMajor)) if scalaMajor >= 11 =>
    unusedWarnings ++ Seq(
      "-Xsource:3"
    )
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  c / console / scalacOptions ~= {_.filterNot(unusedWarnings.toSet)}
)

def gitHashOrBranch: String = scala.util.Try(
  sys.process.Process("git rev-parse HEAD").lineStream_!.head
).getOrElse("master")

Compile / doc / scalacOptions ++= {
  if (isScala3.value) {
    Nil
  } else {
    Seq(
      "-sourcepath", baseDirectory.value.getAbsolutePath,
      "-doc-source-url", s"https://github.com/nscala-time/nscala-time/tree/${gitHashOrBranch}€{FILE_PATH}.scala"
    )
  }
}

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.14.0",
  "org.joda" % "joda-convert" % "3.0.1"
)

libraryDependencies += {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) =>
      "org.scalacheck" %% "scalacheck" % "1.15.2" % "test"
    case _ =>
      "org.scalacheck" %% "scalacheck" % "1.18.1" % "test"
  }
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

console / initialCommands += {
  Iterator("org.joda.time._", "com.github.nscala_time.time.Imports._").map("import " + _).mkString("\n")
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
