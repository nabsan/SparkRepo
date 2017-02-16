package main.scala.ex.basic

import java.io._
import java.util.Properties

//Optionで活用できるパターンマッチングの例
//Optionを使わない例
class Prop(val fname: String) {

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
    val v = prop.getProperty(key)
    if (v != null) v.toInt else 0
  }

  def update(key: String, value: Any) = {
    prop.setProperty(key, value.toString)
    store()
  }
}

object Matching2 extends App {
  def test(): Unit = {
    val prop = new Prop("test.properties")
    val x1 = prop("posX")
    println(x1)

    prop("posX") = 123
    val x2 = prop("posX")
    println(x2)
  }

  test()
}