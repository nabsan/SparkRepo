package main.scala.ex.basic

object Recursion  extends App{

  //メソッド版
  def fact(x: Int) :Int={
    if (x == 1) 1
    else x * fact(x-1)
  }
  def fact_dbg(x:Int):Int={
    println(("- " * (5-x)) + "fact("+x+")")
    val ret = {
      if(x == 1) 1
      else x * fact_dbg(x-1)
    }
    println(("- " * (5-x)) +"fact= "+ret)
    ret
  }

  //関数オブジェクト版
  val factFun: (Int) => Int = (x) => {
    if (x == 1)1
    else x * factFun(x-1)
  }

  def test(): Unit ={
    //通常のRecur。深いとスタックオーバフローになる。
    val a = fact(5)
    val b = factFun(5)

    println("階乗="+a)
    println("階乗2="+b)

    val ad = fact_dbg(5)

  }
  test()


}