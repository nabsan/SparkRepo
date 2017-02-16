package main.scala.ex.basic

object Recursion5  extends App{

  val data1 = List(1,2,5,6,8,9)
  val data2 = List(3,4,7,10)

  def mix(x: List[Int], y: List[Int]):List[Int] ={
    if (x == Nil){
      y
    }else if (y == Nil){
      x
    }else if (x.head < y.head){
      x.head :: mix(x.tail,y)
    }else {
      y.head :: mix(x, y.tail)
    }
  }

  def test(): Unit ={
    val data3 = mix(data1,data2)
    println("ミックス="+data3)
  }





  test()
  //println("----")

}