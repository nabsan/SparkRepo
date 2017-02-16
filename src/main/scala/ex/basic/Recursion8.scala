package main.scala.ex.basic

object Recursion8  extends App{

  val p = "Scala is ?ool!"
  val d1 = "Scala is cool!"
  val d2 = "Scala is goal"
  val d3 = "Scala is coool!"

  //2つのリストが等しいかを比べる再帰処理。
  def samestring(x: String, y: String): Boolean ={
    if (x == "" && y== "") {
      true
    }else if (x=="" || y==""){
      false
    }else if (x.head=='?') {
      samestring(x.tail, y.tail)
    }else if (x.head == y.head) {
      samestring(x.tail, y.tail)
    }else{
      false
    }
  }

  def test(): Unit ={

    println("p : d1 ="+samestring(p,d1))
    println("p : d2 ="+samestring(p,d2))
    println("p : d3 ="+samestring(p,d3))


  }

  test()
  //println("----")

}