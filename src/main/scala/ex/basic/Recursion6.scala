package main.scala.ex.basic


object Recursion6  extends App{

  val p = List (1,2,5,3,9)
  val d1 = List(1,2,5,4,9)
  val d2 = List(1,2,5)
  val d3 = List(1,2,5,3,9)

  //2つのリストが等しいかを比べる再帰処理。
  def samelist(x: List[Int], y: List[Int]): Boolean ={
    if (x == Nil && y== Nil){
      true
    }else if (x==Nil || y == Nil){
      false
    }else if (x.head != y.head){
      false
    }else {
      samelist(x.tail, y.tail)
    }
  }



  def test(): Unit ={

    println("p : d1 ="+samelist(p,d1))
    println("p : d2 ="+samelist(p,d2))
    println("p : d3 ="+samelist(p,d3))

  }





  test()
  //println("----")

}