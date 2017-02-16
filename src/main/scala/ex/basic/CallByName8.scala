package main.scala.ex.basic

import scala.io.Source
import java.io.File
import java.io.FileWriter

//値渡しと名前渡し
object CallByName8  extends App{
                                //その都度評価したいので、名前渡しとなっている。
  def fwloop(file: String, cond: => Boolean, update: => Unit)(body: => String): Unit ={
    var fw: FileWriter = null
    try{
      fw = new FileWriter(new File(file))
      while(cond){
        fw.write(body)
        update
      }
    }catch{
      case e: Exception => println("Error:"+e.getMessage)
    }finally{
      if (fw != null){
        fw.close
      }
    }
  }

  def test(): Unit ={
    val data = List(
      List("番号","国語","数学"),
      List(101,55,78),
      List(102,80,66),
      List(103,95,53),
      List(104,56,67),
      List(105,98,100))

      var a = data
      fwloop("dataout.txt", a.isEmpty, a=a.tail){
        a.head.mkString("¥t")+"\r\n"
      }
  }




}