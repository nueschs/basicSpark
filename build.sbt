import sbt.Keys.resolvers

name := "basicSpark"

version := "1.0"

scalaVersion := "2.11.11"

val sparkVersion = "2.1.0"

updateOptions := updateOptions.value.withCachedResolution(true)
parallelExecution in test := false

resolvers ++= Seq(
  "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Hortonworks" at "http://repo.hortonworks.com/content/repositories/releases/",
  "Hortonworks Groups" at "http://repo.hortonworks.com/content/groups/public/",
  "Apache Snapshots" at "https://repository.apache.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "com.holdenkarau" % "spark-testing-base_2.11" % "2.1.0_0.6.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" withSources() withJavadoc(),
  //  "org.apache.spark" %% "spark-streaming" % "1.3.1" % "provided" withSources() withJavadoc(),
  //  "org.apache.spark" %% "spark-sql" % "1.3.1" % "provided" withSources() withJavadoc(),
  //  "org.apache.spark" %% " spark-hive" % "1.3.1" % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided" withSources() withJavadoc(),
  //  "org.apache.spark" %% "spark-graphx" % "1.3.1" % "provided" withSources() withJavadoc(),
  "org.apache.hadoop" % "hadoop-client" % "2.7.3.2.5.3.0-37" % "provided" withJavadoc(),
  "com.github.scopt" %% "scopt" % "3.2.0"
)
        