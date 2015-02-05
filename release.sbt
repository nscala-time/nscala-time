import sbtrelease._
import ReleaseStateTransformations._

releaseSettings

val sonatypeURL = "https://oss.sonatype.org/service/local/repositories/"

val updateReadme = { state: State =>
  val extracted = Project.extract(state)
  val scalaV = extracted get scalaBinaryVersion
  val v = extracted get version
  val org =  extracted get organization
  val n = extracted get name
  val snapshotOrRelease = if(extracted get isSnapshot) "snapshots" else "releases"
  val readme = "README.md"
  val readmeFile = file(readme)
  val newReadme = Predef.augmentString(IO.read(readmeFile)).lines.map{ line =>
    val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
    if(line.startsWith("libraryDependencies") && matchReleaseOrSnapshot){
      s"""libraryDependencies += "${org}" %% "${n}" % "$v""""
    }else line
  }.mkString("", "\n", "\n")
  IO.write(readmeFile, newReadme)
  val git = new Git(extracted get baseDirectory)
  git.add(readme) ! state.log
  git.commit("update " + readme) ! state.log
  "git diff HEAD^" ! state.log
  state
}

commands += Command.command("updateReadme")(updateReadme)

val updateReadmeProcess: ReleaseStep = updateReadme

ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  updateReadmeProcess,
  tagRelease,
  ReleaseStep(
    action = { state =>
      val extracted = Project extract state
      extracted.runAggregated(PgpKeys.publishSigned in Global in extracted.get(thisProjectRef), state)
    },
    enableCrossBuild = true
  ),
  setNextVersion,
  commitNextVersion,
  updateReadmeProcess,
  ReleaseStep{ state =>
    val extracted = Project extract state
    extracted.runAggregated(SonatypeKeys.sonatypeReleaseAll in Global in extracted.get(thisProjectRef), state)
  },
  pushChanges
)

ReleaseKeys.crossBuild := true

ReleaseKeys.tagName := {
  "releases/" + (version in ThisBuild).value
}
