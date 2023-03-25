import sbtrelease._
import ReleaseStateTransformations._

val updateReadme: State => State = { state =>
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
  val logger = new scala.sys.process.ProcessLogger {
    def buffer[T](f: => T): T = f
    def err(s: => String): Unit = state.log.error(s)
    def out(s: => String): Unit = state.log.info(s)
  }
  git.add(readme) ! logger
  git.commit(message = "update " + readme, sign = false, signOff = false) ! logger
  scala.sys.process.Process("git diff HEAD^") ! logger
  state
}

commands += Command.command("updateReadme")(updateReadme)

val updateReadmeProcess: ReleaseStep = updateReadme

releaseProcess := Seq[ReleaseStep](
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
      extracted.runAggregated(extracted.get(thisProjectRef) / (Global / PgpKeys.publishSigned), state)
    },
    enableCrossBuild = true
  ),
  releaseStepCommandAndRemaining("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  updateReadmeProcess,
  pushChanges
)

releaseCrossBuild := true

releaseTagName := {
  "releases/" + (ThisBuild / version).value
}
