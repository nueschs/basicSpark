package ch.scigility

import com.holdenkarau.spark.testing.{DatasetSuiteBase, SharedSparkContext}
import org.apache.spark.sql.SparkSession
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by snuesch on 15.06.17.
  */
class CharCounterSpec extends FunSuite with DatasetSuiteBase with Matchers{
  implicit val sparkImpl: SparkSession = spark
  import sparkImpl.implicits._

  test("CharCount test"){
    val words = Seq("asdf", "jklö", "foo", "bar", "baz")
    val wordsDS = sparkImpl.createDataset(words)
    val res = CharCounter.countLetters(wordsDS)
    res.count should be (12)
    res.collect.max should be (3)
  }
}