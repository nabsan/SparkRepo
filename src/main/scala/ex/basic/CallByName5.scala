package main.scala.ex.basic

import javax.xml.parsers.DocumentBuilderFactory

//値渡しと名前渡し
object CallByName5  extends App{
  //値渡し
  def testloop(n: Int)(bodyFun: (Int) => Unit): Unit ={
    for (i <- 1 to n) {
      if (Range(2,i).toList.forall(x => i % x != 0)){
        bodyFun(i)
      }
    }
  }

  //名前渡し
  def testloopByName(n: Int)(bodyFun: => (Int) => Unit ){
    for (i <- 1 to n) {
      if (Range(2,i).toList.forall(x => i % x != 0)){
        bodyFun(i)
      }
    }
  }

  def test1(): Unit ={
    println("----------素数出力(関数オブジェクトの値渡しversion)")
    testloop(20){
      println("hoge")//処理A                                   //１回しか評価されない？
      x =>
        println(x)
    }
  }

  def test2(): Unit ={
    println("----------素数出力(関数オブジェクトの名前渡しversion)")
    testloopByName(20){
      println("foo") //処理A                                   //毎回評価される
      x =>
        println(x)
    }
  }

  test1()
  test2()















}