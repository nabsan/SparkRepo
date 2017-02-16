package main.scala.ex.basic

object Recursion2  extends App{

  val data = List(7,8,2,3,4,9,10,5,1,6)
  def sum(x:List[Int]): Int = {
    if (x.tail == Nil) x.head
    else x.head + sum(x.tail)
  }



  var level = 0
  def sum_with_level(x : List[Int]):Int={
    println(("- " * level) + "sum ("+ x + ")")
    level += 1
    val ret ={
      if (x.tail == Nil) x.head
      else x.head + sum_with_level(x.tail)
    }
    level -= 1
    println(("- " * level)+ "sum ="+ ret)
    ret
  }

  def sum_util(x: List[Int]): Int = {
    my.Util.trace("sum",x){
      if (x.tail == Nil) x.head
      else x.head + sum_util(x.tail)
    }
  }

  //if の条件式を変えたので、一回層深くなっている。答えは同じ。
  def sum2(x:List[Int]):Int ={
    my.Util.trace("sum2",x){
      if (x == Nil) 0
      else x.head + sum2(x.tail)
    }
  }

  def test(): Unit ={
    val g = sum(data)
    println("合計="+g)
    val g2 = sum_with_level(data)
    println("合計2="+g2)
    val g3 = sum_util(data)
    println("合計3="+g3)
    val g4 = sum2(data)
    println("合計4="+g4)
  }

  test()
  //println("----")

}