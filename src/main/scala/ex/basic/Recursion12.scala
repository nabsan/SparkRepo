package main.scala.ex.basic

object Recursion12  extends App{
  val p = List(1,2,5,3,9)
  val d1 = List(1,2,5,4,9)
  val d2 = List(1,2,5)
  val d3 = List(1,2,5,3,9)


  def samelist(x: List[Int],y: List[Int]): Boolean ={
    (x,y) match{
      case (Nil, Nil) => true
      case (Nil,_) | (_,Nil) => false
      case (a::aa, b::bb) if (a==b) => samelist(aa,bb)
      case _ =>         false
    }
  }

  def test(): Unit ={

    println("p : d1 =" + samelist(p,d1))
    println("p : d2 =" + samelist(p,d2))
    println("p : d3 =" + samelist(p,d3))


  }

  test()
  //println("----")

}