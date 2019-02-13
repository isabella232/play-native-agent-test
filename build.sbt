name := "play-native-agent-test"
version := "0.0.1"
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.rollbar" % "rollbar-java" % "1.4.0"
)

enablePlugins(PlayScala)
disablePlugins(PlayLayoutPlugin)
