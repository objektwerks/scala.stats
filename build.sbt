enablePlugins(JlinkPlugin)

name := "scalafx.stats"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.4"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "14-R19",
    "org.scalatest" %% "scalatest" % "3.2.4" % Test
  )
}
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m => "org.openjfx" % s"javafx-$m" % "14.0.1" classifier osName )
jlinkModules := {
  jlinkModules.value :+ "jdk.unsupported"
}
jlinkIgnoreMissingDependency := JlinkIgnore.everything
