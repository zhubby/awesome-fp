package com.github.ultramans.remix.lib.implicits

import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.{Date, Random}

import org.joda.time.DateTime
import scalaz.Scalaz._

object PrimitiveType {

  private[PrimitiveType] final val COMMA = ","

  implicit class IntImplicit(i: Int) {
    def toRandomString: String = {
      val random = new Random()
      var temp = List.empty[Char]
      val seed = ('a' |-> 'z') ++ ('A' |-> 'Z')
      (1 |-> i).foreach {
        _ => temp = temp :+ seed.index(random.nextInt(seed.length)).get
      }
      temp.map(_.toString).reduce(_ + _)
    }

    def toRandomNumber: Int = {
      scala.util.Random.nextInt()
    }
  }

  implicit class ArrayImplicit(arr: Array[String]) {
    def joinWithComma: String = arr.reduce(_ + COMMA + _)
  }

  implicit class SeqImplicit(arr: Seq[String]) {
    def joinWithComma: String = arr.reduce(_ + COMMA + _)
  }

  implicit class StringImplicit(s: String) {
    def toMD5: String = {
      val messageDigest = MessageDigest.getInstance("md5")
      messageDigest.update(s.getBytes)
      new BigInteger(1, messageDigest.digest).toString(16)
    }

    def toSHA1: String = {
      val messageDigest = MessageDigest.getInstance("sha1")
      messageDigest.update(s.getBytes)
      new BigInteger(1, messageDigest.digest).toString(16)
    }

    def splitWithComma: Array[String] = {
      if (s.length == 0) Array[String]() else if (s.endsWith(COMMA)) s.substring(0, s.length - 1).split(COMMA) else s.split(COMMA)
    }

    def timestampToDateFormat: String = {
      val format = "yyyy-MM-dd HH:mm:ss"
      val sdf = new SimpleDateFormat(format)
      sdf.format(new Date(s.concat("000").toLong))
    }

    def dateFormatToTimestamp: String = {
      val format = "yyyy-MM-dd HH:mm:ss"
      val sdf = new SimpleDateFormat(format)
      (sdf.parse(s).getTime / 1000).toString
    }

    def isNumber: Boolean = {
      val reg = "([0-9]*)".r
      s match {
        case reg(_) => true
        case _ => false
      }
    }
  }

  implicit class DateImplicit(date: Date) {
    def toTimestamp: Int = (date.getTime / 1000L).toInt

    def toTimestampString: String = (date.getTime / 1000L).toString

    def beforeDay(day: Int): Date = DateTime.now().minus(day).toDate

    def afterDay(day: Int): Date = DateTime.now().plus(day).toDate
  }

}
