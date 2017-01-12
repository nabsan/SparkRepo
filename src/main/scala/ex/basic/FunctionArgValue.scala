package main.scala.ex.basic

object FunctionArgValue  extends App{
  
  def fun2(x: Int)={
    x * 3.14
  }
  
  def fun1(r: Int) = {
    fun2(r * r)
  }
  
  def test1(){
    val a = math.sin(3.14)
    println(a)
    
    val b = fun1(2)
    println(b)
  }
  
  test1()
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}

}