package ch.scigility

import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by snuesch on 15.06.17.
  */
object SparkJobBase {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Char_Count").master("local").getOrCreate()
    import spark.implicits._
    val fileName = "./src/main/resources/google-10000-english.txt"

    val lines: Dataset[String] = spark.read.textFile(fileName)

    val count = CharCounter.countLetters(lines)
    println(count)

    spark.stop()

  }
}
