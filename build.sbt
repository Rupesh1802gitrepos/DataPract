name := "DataStructure"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
//libraryDependencies += "oracle" % "ojdbc6" % "11.2.0.3"
//libraryDependencies += "com.oracle" % "ojdbc14" % "10.2.0.4.0"

// AWS Redshift related dependency
libraryDependencies += "com.databricks" % "spark-redshift_2.11" % "3.0.0-preview1"
libraryDependencies += "com.amazon.redshift" % "redshift-jdbc42" % "1.2.1.1001"
dependencyOverrides += "com.databricks" % "spark-avro_2.11" % "3.2.0"