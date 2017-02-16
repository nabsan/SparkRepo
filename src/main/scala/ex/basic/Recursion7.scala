package main.scala.ex.basic

object Recursion7  extends App{

  val p = List (1,2,5,3,9)
  val d1 = List(1,2,5,4,9)
  val d2 = List(1,2,5)
  val d3 = List(1,2,5,3,9)

  //2つのリストが等しいかを比べる再帰処理。
  def cmplist(x: List[Int], y: List[Int]): Int ={
    if (x == Nil && y== Nil){
      0
    }else if (x==Nil) {
      -1
    }else if (y==Nil){
      1
    }else if (x.head < y.head){
      -1
    }else if (x.head > y.head){
      1
    }else {
      cmplist(x.tail, y.tail)
    }
  }



  def test(): Unit ={

    println("p : d1 ="+cmplist(p,d1))
    println("p : d2 ="+cmplist(p,d2))
    println("p : d3 ="+cmplist(p,d3))

  }

  test()
  //println("----")

}