package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//Clojureを使わない場合の例
object Clojure  extends App{
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
  
  val yotei = List("2016/01/23","2016/01/27","2016/02/02","2016/02/14","2016/02/18")   //グローバル変数
  var count = 0                                                                        //グローバル変数
  
  def hyouji(s: String, fmt: String, wareki: Boolean){
    println("-------hyoujiの呼び出し")
    val inFmt = new SimpleDateFormat("yyyy/MM/dd")
    val outFmt =new SimpleDateFormat(fmt, if (wareki) new Locale("ja","JP","JP") 
                           else Locale.ENGLISH)
    count += 1
    println(count +" " + outFmt.format(inFmt.parse(s)))
  }
  
  
  def test1(){
    println("==== 予定表示1====")
    yotei.map(s => hyouji(s, "yyyy.M.d(E)",false))
  }
  
  def test2(){
    println("==== 予定表示2 ====")
    count = 0
    yotei.map(s => hyouji(s, "Gyy.M.d(E)", true))
  }
  test1()
  test2()
  

}