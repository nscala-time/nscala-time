import Defaults._

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

libraryDependencies <<= (scalaVersion, libraryDependencies) {(version, dependencies) =>
  if (!version.startsWith("2.10"))
    dependencies :+ sbtPluginExtra("reaktor" % "sbt-scct" % "0.2-SNAPSHOT", "0.12", version)
  else
    dependencies
}
