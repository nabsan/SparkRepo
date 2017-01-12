package main.scala.ex.basic

import my._


object Literal  {
   val num1 = 123
   val num2 = 123.4
   val ch = 'A'
   val str ="ABC"
   val bol = true
   val lst1 = 1::2::3::Nil
   val lst2 =List(1,2,3)
   
   //関数オブジェクト
   val fun1 = (x: Int) => x * x
   val fun2 = (x: Int, y: Int) => (x + y) / 2.0
   val fun3 = (x: Int, y: String, z: Int) => x + y + z
   
   def test1() {
      println("\n=== test1 リテラルの値と型 === \n")
      val fmt = "%-4s の値は %-15s 型は %s \n"
      printf(fmt, "numb1", num1, my.Util.typeName(num1))
      printf(fmt, "numb2", num2, my.Util.typeName(num2))
      printf(fmt, "ch", ch, my.Util.typeName(ch))
      printf(fmt, "str", str, my.Util.typeName(str))
      printf(fmt, "bol",bol, my.Util.typeName(bol))
      printf(fmt, "lst1", lst1, my.Util.typeName(lst1))
      printf(fmt, "lst2", lst2, my.Util.typeName(lst2))
      printf(fmt, "fun1", fun1, my.Util.typeName(fun1))
      printf(fmt, "fun2", fun2, my.Util.typeName(fun2))
      printf(fmt, "fun3", fun3, my.Util.typeName(fun3))
   }
   
   
   def test2(){
     println("\n --- test2 関数呼び出し式の値と型 === \n")
     val fmt2="%-14s の値は %-5s 型は%s \n"
     printf(fmt2,"fun1(2)", fun1(2), my.Util.typeName(fun1(2)))
     printf(fmt2,"fun2(2,5)", fun2(2,5), my.Util.typeName(fun2(2,5)))
     printf(fmt2,"fun3(2,;,5)", fun3(2,";",5), my.Util.typeName(fun3(2,";",5)))
   }
   
   def main(args: Array[String]): Unit = {
   test1()
   test2()
   }
   
   
   
}