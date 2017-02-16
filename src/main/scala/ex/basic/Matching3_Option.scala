package main.scala.ex.basic

import java.io._
import java.util.Properties

//Optionで活用できるパターンマッチングの例
//Optionを使う例
class Prop2(val fname: String) {

  val prop = new Properties()
  load()

  def load() = {
    try {
      prop.load(new FileInputStream(fname))
      true
    } catch {
      case e: IOException => false
    }
  }

  def store() = {
    try {
      prop.store(new FileOutputStream(fname), "")
      true
    } catch {
      case e: IOException => false
    }
  }

  def apply(key: String) = {
    Option(prop.getProperty(key))       //Optionにくるんで返すだけに変更。
    //if (v != null) v.toInt else 0
  }

  def update(key: String, value: Any) = {
    prop.setProperty(key, value.toString)
    store()
  }
}

object Matching3 extends App {

  def get(x: Option[String]) ={
    x match {
      case Some(a) => a.toInt
      case None => 100          //デフォルト値をここで宣言！
    }
  }

  def test(): Unit = {
    val prop = new Prop2("test.properties")
    val x1 = get(prop("posX"))                 //もしなければ、デフォ値が　ここに入る。
    println(x1)

    prop("posX") = 156
    val x2 = get(prop("posX"))
    println(x2)
  }

  test()
}