package main.scala.ex.basic

object Data_Currying  extends App{
  def judge(right: List[Int], ans: List[Int]) ={
     println("----- judge")
     right.zip(ans).map(pair => pair._1 == pair._2)
  }

  def calc(point: List[Int], right: List[Int], ans: List[Int]) = {
    println("----- calc")
    judge(right,ans).zip(point).map(pair => if (pair._1) pair._2 else 0).sum
  }

  def test1(): Unit ={
    println("=== 各メソッドが返すリストの確認")
    println("正解=" + Data.loadRight())
    println("答案=" + Data.loadAnswer())
    println("配点="+ Data.loadPoint())
    println("判定="+ judge(Data.loadRight(),Data.loadAnswer()))
  }

  def test2(): Unit = {
    println("=== 個人採点処理 ===")
    val pt = calc(Data.loadPoint(),Data.loadRight(),Data.loadAnswer())
    println("点数="+pt)
  }

  def test3() ={
    println("=== 団体採点処理 ===")
    val ptAll = Data.loadAnswers().map(
      answer => calc(Data.loadPoint(),Data.loadRight(),answer))
    println("点数="+ ptAll)

  }

  def test4(): Unit ={
    println("===団体採点処理（変数利用)===")
    val answers =Data.loadAnswers()
    val point = Data.loadPoint()
    val right = Data.loadRight()
    val ptAll = answers.map(answer => calc(point,right,answer))
    println("点数="+ptAll)
  }
  test1()
  test2()
  test3()
  test4()

}