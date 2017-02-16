package main.scala.ex.basic

object Recursion3  extends App{

  val data = List(7,8,2,3,4,9,10,5,1,6)

  def rev(x:List[Int]): List[Int] = {
    if (x == Nil) Nil                  //繰り返しの終了処理
    else rev(x.tail) :::List(x.head)    //"再帰の結果の最後に、先頭を追加する”という処理となる。
  }


  def test(): Unit ={
    val g = rev(data)
    println("逆順="+g)

  }

  test()
  //println("----")

}