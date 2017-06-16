package ch.scigility

import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by snuesch on 15.06.17.
  */
class CharCounterSpec extends FunSuite with SharedSparkContext with Matchers{

  test("CharCount test"){
    val words = Seq("asdf", "jklö", "foo", "bar", "baz")
    val rdd = sc.parallelize(words)
    val res = CharCounter.countLetters(rdd)
    res.size should be (12)
    res.values.max should be (3)
  }
}