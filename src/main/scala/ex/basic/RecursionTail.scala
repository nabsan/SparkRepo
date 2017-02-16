package main.scala.ex.basic

import scala.annotation.tailrec

/**
  * [末尾再帰最適化について]
  * ・基本的に、再帰的呼び出しの際、値をスタックに保留にする必要がある場合は、末尾最適化はされない。
  * ・再帰呼出し同士の演算が含まれていれば末尾再帰最適化はされない。
  * ・必ずしも関数の最下行の式が再帰呼び出しでなければならないというわけではない。
  * ・すべての再帰呼び出しが、関数が返す式に位置しかつ、式の最後の演算が再帰呼び出しなら末尾再帰最適化はされる。
  * ・再帰関数の頭に@tailrecアノテーションを付けると、末尾最適できない場合は怒られる
  *
  */
object RecursionTail  extends App{

  val data = List(7,8,2,3,4,9,10,5,1,6)

  //@tailrec                       //これでエラーがおきる。末尾位置に再帰呼び出しがないため、最適化できない為。
  def sum(x: List[Int]): Int = {
    if (x.tail == Nil) x.head
    else x.head + sum(x.tail)
  }

  @tailrec                         //sumTailはエラーは起きない。
  def sumTail(x: List[Int]):Int ={
    if (x.tail == Nil) x.head
    else sumTail(x.head + x.tail.head :: x.tail.tail)
  }

  @tailrec                         //これもエラーは起きない。
  def sumTail2(x: List[Int], a:Int):Int = {
    if (x == Nil) a
    else sumTail2(x.tail, a + x.head)
  }

  def test(): Unit ={
    println(sum(data))
    println(sumTail(data))
    println(sumTail2(data,0))
    //println("合計="+g)

  }

  test()
  //println("----")

}