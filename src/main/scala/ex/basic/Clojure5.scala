package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//血液型集計プログラム(Clojure4.scalaのコード削減verな例。Clojureもつかわない例）
object Clojure5  extends App{
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
  
   //
  val btp = Array("A","B","O","AB")  //血液型
  val ma = Array(45, 43, 35, 28)   //男人数
  val fe = Array(48,51,29,33)     //女人数
  
  
  def output(sw: Int) = {
    val sum = new Array[Int](4)    // 合計人数
    val r = new Array[Double](4)   //血液型構成比(%)
    val mr = new Array[Double](4)  //男女比(%)
    var n=0
    for (i <- 0 to 3){
      sum(i) = ma(i) +fe(i)
      n += sum(i)
    }
    var s =""
    for (k <- 0 to 3){
     
      val percent = (x:Double) => BigDecimal(x * 100)
          .setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
      r(k)  = percent(sum(k).toDouble/n)
      mr(k) = percent(ma(k).toDouble / sum(k))
      
      if(sw ==1)
    	  	s+=btp(k)+" " + sum(k) + " "+ r(k) +" " + mr(k) + " " + (100 - mr(k)) + "\n"
         else if (sw == 2)
           s+=btp(k)+"	" + sum(k) + "	"+ r(k) +"	" + mr(k) + "	" + (100 - mr(k)) + "\n"
         else
           s+=btp(k)+"," + sum(k) + ","+ r(k) +"," + mr(k) + "," + (100 - mr(k)) + "\n"
    }
    s
  }
  
  
  println(output(1))
  println(output(2))
  println(output(3))
  
  

}