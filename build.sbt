import play.Project._

name := "tdh"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(  
  	"mysql" % "mysql-connector-java" % "5.1.18",
    "org.hibernate" % "hibernate-entitymanager" % "4.1.10.Final",
    "com.google.code.gson" % "gson" % "2.2.2",
    "org.apache.directory.studio" % "org.apache.commons.io" % "2.4",
    "org.mindrot" % "jbcrypt" % "0.3m",
    javaCore,
    javaJdbc,
    javaEbean,
    javaJpa,
  	cache
)     

play.Project.playJavaSettings