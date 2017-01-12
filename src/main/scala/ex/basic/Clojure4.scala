package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//血液型集計プログラム(オーソドックスな例。Clojureもつかわない例）
object Clojure4  extends App{
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
  
   //
  val btp = Array("A","B","O","AB")  //血液型
  val ma = Array(45, 43, 35, 28)   //男人数
  val fe = Array(48,51,29,33)     //女人数
  val sum = new Array[Int](4)    // 合計人数
  val r = new Array[Double](4)   //血液型構成比(%)
  val mr = new Array[Double](4)  //男女比(%)
  
  def total()={
    var t=0
    for (i <- 0 to 3){
      sum(i) = ma(i) +fe(i)
      t += sum(i)
    }
    t
  }
  
  def calc() {
    val n = total()
    val percent = (x:Double) => BigDecimal(x * 100)
        .setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    for (j <- 0 to 3){
     r(j)  = percent(sum(j).toDouble/n)
     mr(j) = percent(ma(j).toDouble / sum(j))
    }
  }
  
  def output(sw: Int) = {
    var s =""
    for (k <- 0 to 3){
      if(sw ==1)
    	  	s+=btp(k)+" " + sum(k) + " "+ r(k) +" " + mr(k) + " " + (100 - mr(k)) + "\n"
         else if (sw == 2)
           s+=btp(k)+"	" + sum(k) + "	"+ r(k) +"	" + mr(k) + "	" + (100 - mr(k)) + "\n"
         else
           s+=btp(k)+"," + sum(k) + ","+ r(k) +"," + mr(k) + "," + (100 - mr(k)) + "\n"
    }
    s
  }
  
  calc()
  println(output(1))
  println(output(2))
  println(output(3))
  
  

}