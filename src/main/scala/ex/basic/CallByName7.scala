package main.scala.ex.basic

import scala.io.Source

//値渡しと名前渡し
object CallByName7  extends App{
  def fileloop(file: String)(bodyFun: => (String) => Unit) {
    var src: Source = null
    try{
      src = Source.fromFile(file)
      for (line <- src.getLines()){
        bodyFun(line)
      }
    }catch{
      case e: Exception => println("Error:"+e.getMessage())
    }finally{
      if (src != null) src.close()
    }
  }

  def test1(): Unit ={
    println("番号¥t国語¥t数学")
    fileloop("log.txt"){
      line =>
        println(line)
    }
  }


  def test2(): Unit ={
    println("番号¥t合計点")
    fileloop("log.txt"){
      line =>
        val s = line.split("¥¥ss+").map(x => x.toInt)
        println(s(0)+"¥t" + (s(1)+ s(2)))
    }
  }





  test1()
  test2()




}