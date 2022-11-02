import scala.scalanative.build._

val http4sVersion = "1.0.0-M37"
val epollcatVersion = "0.1.1"

ThisBuild / scalaVersion := "3.2.0"

lazy val ember = crossProject(JVMPlatform, NativePlatform)
  .settings(
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-ember-server" % http4sVersion
    )
  )
  .nativeSettings(
    libraryDependencies ++= Seq(
      "com.armanbilge" %%% "epollcat" % epollcatVersion
    ),
    nativeLinkingOptions += "-L/usr/local/opt/openssl@1.1/lib"
  )
  .dependsOn(core)

lazy val snunit = project
  .settings(
    libraryDependencies ++= Seq(
      "com.github.lolgab" %%% "snunit-http4s1" % snunitVersion,
      "com.github.lolgab" %%% "snunit-async-epollcat" % snunitVersion
    )
    // On Ubuntu the control.sock is protected and available for root only
    // , snunitCurlCommand := Seq("sudo", "curl")
  )
  .enablePlugins(SNUnitPlugin)
  .dependsOn(core.native)

lazy val core = crossProject(JVMPlatform, NativePlatform)
  .settings(
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-dsl" % http4sVersion
    )
  )
