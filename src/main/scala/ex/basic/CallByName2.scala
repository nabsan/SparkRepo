package main.scala.ex.basic

import javax.swing.JOptionPane

//値渡しと名前渡し
object CallByName2  extends App{
  //解説：
  //１１１,222は値渡しだと１回（引数として渡される前に）実行され、
  //名前渡しだと、3回loop中に評価される。
  //実行されるタイミングが違うので、面白い。
  
  
  
  
  //値渡し(渡す前に評価される。)
  def loopA(body: Unit){
    println("-----loopA")
    for (i <- 1 to 3){
      body
    }
  }
  
  //名前渡し（使われるときに評価:遅延評価 される）
  def loopB(body: => Unit){
    println("------loopB")
    for(i <- 1 to 3){
      body
    }
  }
  
  def test1(){
    println("---- 値渡し")
    loopA{
      println(111)
      println(222)
    }
  }
  
  def test2(){
    println("---- 名前渡し")
    loopB{
      println(111)
      println(222)
    }
  }
  test1()
  test2()
  
  
}