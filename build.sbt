enablePlugins(SNUnitPlugin)
scalaVersion := "3.2.0"
libraryDependencies ++= Seq(
  "org.http4s" %%% "http4s-dsl" % "1.0.0-M37",
  "com.github.lolgab" %%% "snunit-http4s1" % "0.1.1"
)
