package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//Clojureを使った円の計算の例
object Clojure3  extends App{
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
  
   //ここ！　関数オブジェクト+環境変数＝クロージャです！
   def menseki(v: Double) = {
      val pi = v
      (r: Double) => {
        r * r * pi
      }
  }

   def test1(){
      println("====円の面積(パイの精度:3) ===")
      val f1=menseki(3)
      println(f1(2))
      println(f1(3))
      println(f1(4))
   }
   
   def test2(){
     println("=== 円の面積（パイの精度: 3.141592)===")
     val f2 = menseki(3.141592)
     println(f2(2))
     println(f2(3))
     println(f2(4))
   }
   test1()
   test2()
  

}