name := "Test Project"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.6.2"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

