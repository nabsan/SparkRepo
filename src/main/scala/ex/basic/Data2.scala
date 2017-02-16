package main.scala.ex.basic

import my.Util._

object Data2   {

  var a: List[Int] = Nil
  var b: List[Int] = Nil
  var c: List[List[Int]] = Nil

  def init(): Unit = {
    for (i <- 1 to 10) a = a ::: List(2, 1, 2, 2, 2, 4, 3, 2, 3, 2)
    for (i <- 1 to 10) b = b ::: List(5, 5, 10, 10, 15, 15, 5, 10, 10, 15)

    var d: List[Int] = Nil
    for (i <- 1 to 10) d = d ::: List(2, 1, 2, 3, 1, 3, 4, 2, 2, 2)
    println("d="+d)
    for (i <- 1 to 100) c = d :: c
    println("c="+c)
  }

  def loadRight(): List[Int] = {
    val start = System.nanoTime()
    while ((System.nanoTime() - start) / 1000000 < 1) {}
    a
  }

  def loadPoint() = {
    val start = System.nanoTime()
    while ((System.nanoTime() - start)/1000000 < 1) {}
    b
  }


  def loadAnswers(): List[List[Int]] = {
    val start = System.nanoTime()
    while ((System.nanoTime() - start)/1000000 < 10) {}
    c
  }
}

object CurryingBench extends App {
  def judge(right: List[Int], ans: List[Int]) ={
    right.zip(ans).map(pair => pair._1 == pair._2)
  }

  def calc(point: List[Int], right: List[Int], ans: List[Int])={
    judge(right, ans).zip(point).map(
       pair => if(pair._1) pair._2 else 0).sum
  }


  def calcCurrying(point: List[Int])(right: List[Int])(ans: List[Int]) ={
    judge(right,ans).zip(point).map(
      pair => if(pair._1) pair._2 else 0).sum
  }

  def test1(){
    //
    my.Util.stopWatchMsecToLog("log.txt") {
    //my.Util.stopWatchMsec() {
      val f1 = (answer: List[Int]) =>
        calc(Data2.loadPoint(), Data2.loadRight(), answer)
      val ptAll1 = Data2.loadAnswers().map(f1)
      println("ptAll1="+ptAll1)
    }
  }


  def test2(): Unit ={
    my.Util.stopWatchMsecToLog("log.txt"){
    //my.Util.stopWatchMsec() {
        val f2 = calc(Data2.loadPoint(), Data2.loadRight(), _: List[Int])
        println("---test2")
        val ptAll2 = Data2.loadAnswers().map(f2)
        println("ptall2="+ptAll2)
    }
  }

  //カリー化版が一番早い!
  def test3() ={
    my.Util.stopWatchMsecToLog("log.txt"){
    //my.Util.stopWatchMsec() {
      val f3 = calcCurrying(Data2.loadPoint())(Data2.loadRight())_
      val ptAll3=Data2.loadAnswers().map(f3)
      println("ptAll3="+ptAll3)
    }
  }

  Data2.init()
  //注意!　初期化に対して、、1testつづつ評価すること！
  //test1()   //普通バージョン
  //test2()  //部分関数バージョン。初回起動時が一番時間がかかる。
  //test3()   //カリー化バージョン(高速) 初回起動時が一番かかるのは同じだが、読み込み処理以外はあまり時間がかかってないほどはやい。

  var i=0
  while (i< 10){
    //test2()
    test3()
    i += 1
  }


}