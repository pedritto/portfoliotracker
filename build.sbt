name := "portfoliotracker"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.squeryl" %% "squeryl" % "0.9.5-6",
  "com.cloudphysics" % "jerkson_2.10" % "0.6.3"
)     

play.Project.playScalaSettings
