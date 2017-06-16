package ch.scigility

import org.apache.spark.rdd.RDD

/**
  * Created by snuesch on 15.06.17.
  */
object CharCounter {
  def countLetters(rdd: RDD[String]) = {
    rdd.flatMap(_.split("")).map(c => (c,1)).countByKey()
  }
}
