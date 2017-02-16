package main.scala.ex.basic

object Recursion9  extends App{

  val p = "Scala is *ool!"
  val d1 = "Scala is cool!"
  val d2 = "Scala is goal"
  val d3 = "Scala is pool!"
  val d4 = "Scala is cococococool!"

  //2つのリストが等しいかを比べる再帰処理。
  def samestring2(x: String, y: String): Boolean ={
    if (x == "" && y== "") {
      true
    }else if (x=="" || y==""){
      false
    }else if (x.head=='*') {
      if (samestring2(x.tail, y.tail)){
        true
      }else{
        samestring2(x,y.tail)
      }
    }else if (x.head == y.head) {
      samestring2(x.tail, y.tail)
    }else{
      false
    }
  }

  def test(): Unit ={

    println("p : d1 ="+samestring2(p,d1))
    println("p : d2 ="+samestring2(p,d2))
    println("p : d3 ="+samestring2(p,d3))
    println("p : d3 ="+samestring2(p,d4))

    println("test=" + samestring2("* is *.","Scala is good."))
    println("test=" + samestring2("* is *.","The Apple is red."))


  }

  test()
  //println("----")

}