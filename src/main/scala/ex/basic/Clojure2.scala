package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//Clojureを使った場合の例
object Clojure2  extends App{
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
  
  val yotei = List("2016/01/23","2016/01/27","2016/02/02","2016/02/14","2016/02/18")
  //var count = 0    //使わない・↓のclojure部へ移動！
  
  //ここ！　関数オブジェクト+環境変数＝クロージャ
  def hyouji(fmt: String, wareki: Boolean)={
    println("-------hyoujiの呼び出し")
    val inFmt = new SimpleDateFormat("yyyy/MM/dd")
    val outFmt =new SimpleDateFormat(fmt, if (wareki) new Locale("ja","JP","JP") else Locale.ENGLISH)
    var count = 0
    
    //戻り値となる関数オブジェクト(関数リテラル)
    (s: String) => {
      println("===clojureのよびだし！===")
      count += 1
      println(count +" " + outFmt.format(inFmt.parse(s)))  
    }
  }
  
  val hyouji1 = hyouji("yyyy.M.d(E)",false)
  val hyouji2 = hyouji("Gyy.M.d(E)", true)
  
  def test1(){
    println("==== 予定表示1====")
    yotei.map(s => hyouji1(s))
  }
  
  def test2(){
    println("==== 予定表示2 ====")
    
    yotei.map(s => hyouji2(s))
  }
  test1()
  test2()
  

}