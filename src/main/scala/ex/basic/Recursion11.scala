package main.scala.ex.basic

object Recursion11  extends App{

  val data1 = List(1,2,5,6,8,9)
  val data2 = List(3,4,7,10)


  def mix(x: List[Int],y: List[Int]): List[Int] ={
    (x,y) match{
      case (Nil, _) =>y
      case (_,Nil) => x
      case (a::aa, b::bb) => if (a<b) a:: mix(aa,y)
      else         b:: mix(bb,x)
    }
  }

  def test(): Unit ={

    val data3= mix(data1,data2)
    println("ミックス="+data3)

  }

  test()
  //println("----")

}