resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.7.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.1.5")

addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.1")
