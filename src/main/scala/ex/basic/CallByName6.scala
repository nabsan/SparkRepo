package main.scala.ex.basic

import scala.io.Source

//値渡しと名前渡し
object CallByName6  extends App{
  def test(): Unit = {
    var src: Source = null
    try {
      src = Source.fromFile("log.txt")
      for (line <- src.getLines()) {
        println("line=" + line)
      }
    } catch {
      case e: Exception => println("Error:" + e.getMessage())
    } finally {
      if (src != null) src.close()
    }
  }


  test()




}