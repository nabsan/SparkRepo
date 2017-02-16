package main.scala.ex.basic

import java.io._
import java.util.Properties

//Optionで活用できるパターンマッチングの例
//Optionを使う例２（更に汎用性を高めたver)
class Prop3(val fname: String) {

  val prop = new Properties()
  load()

  def apply[T](key: String, default: T) ={          //applyを変更
    (Option(prop.getProperty(key)), default) match{
      case (Some(a), d: Int) => a.toInt
      case (Some(a), _) => a
      case (None, _) => default
    }
  }

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

  def update(key: String, value: Any) = {
    prop.setProperty(key, value.toString)
    store()
  }
}

object Matching4 extends App {



  def test(): Unit = {
    val prop = new Prop3("test.properties")
    val x1 = prop("posX",100)                 //デフォルト値を指定可能となった
    println("x1="+x1)

    val u = prop("username", "taro1")
    //prop("posX") = 200
    //val x2 = prop("posX","300")
    println("hello2:"+u)
  }

  test()
}