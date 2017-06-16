package ch.scigility

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, Encoder, SparkSession}

/**
  * Created by snuesch on 15.06.17.
  */
object CharCounter {
  def countLetters(rdd: Dataset[String])(implicit ev:Encoder[(String, Int)]) =
    (
      for {
        str <- rdd
        ch <- str
      } yield (ch.toString, 1)
    ).rdd
      .countByKey()



  
}
