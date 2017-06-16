package ch.scigility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by snuesch on 15.06.17.
  */
object SparkJobBase {

  var sc: SparkContext = _

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Char Count").setMaster("local")
    sc = new SparkContext(conf)

    val lines = sc.textFile("google-10000-english.txt")

    val count = CharCounter.countLetters(lines)
    println(count)

  }
}
