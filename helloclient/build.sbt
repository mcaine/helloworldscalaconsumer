import ScalaxbKeys._

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
lazy val dispatchV = "0.11.2"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV

lazy val root = (project in file(".")).
  settings(
    organization  := "com.example",
    name          := "helloclient",
    scalaVersion  := "2.11.4",
    libraryDependencies ++= Seq(dispatch),
    libraryDependencies ++= {
      if (scalaVersion.value startsWith "2.11") Seq(scalaXml, scalaParser)
      else Seq()
    }).
  settings(scalaxbSettings: _*).
  settings(
    sourceGenerators in Compile <+= (scalaxb in Compile),
    dispatchVersion in (Compile, scalaxb) := "0.11.2",
    async in (Compile, scalaxb)           := true,
    packageName in (Compile, scalaxb)     := "generated"
    // packageNames in (Compile, scalaxb)    := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization"),
    // logLevel in (Compile, scalaxb) := Level.Debug 
  )
