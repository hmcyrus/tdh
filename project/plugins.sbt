// Comment to get more information during initialization
logLevel := Level.Warn

resolvers ++= Seq(  
  	"jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)  

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.5") 