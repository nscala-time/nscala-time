import Defaults._

resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.2.0")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

addSbtPlugin("com.jsuereth" % "xsbt-gpg-plugin" % "0.6")

libraryDependencies <<= (scalaVersion, libraryDependencies) {(version, dependencies) =>
  if (!version.startsWith("2.10"))
    dependencies :+ sbtPluginExtra("reaktor" % "sbt-scct" % "0.2-SNAPSHOT", "0.12", version)
  else
    dependencies
}
