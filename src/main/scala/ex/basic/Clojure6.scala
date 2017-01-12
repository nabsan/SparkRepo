package main.scala.ex.basic

import java.util.Locale
import java.text.SimpleDateFormat

//血液型集計プログラム(Clojureをつかう例。clojure5.scalaよりコード量こそ若干増えたが、動作速度は倍速い!->clojureで共通処理は流用するため。）
object Clojure6  extends App{
  
   //
  val btp = Array("A","B","O","AB")  //血液型
  val ma = Array(45, 43, 35, 28)   //男人数
  val fe = Array(48,51,29,33)     //女人数
  
  
  def output() = {
    val sum = new Array[Int](4)    // 合計人数
    val r = new Array[Double](4)   //血液型構成比(%)
    val mr = new Array[Double](4)  //男女比(%)
    var n=0
    for (i <- 0 to 3){
      sum(i) = ma(i) +fe(i)
      n += sum(i)
    }
    var s =""
    for (j <- 0 to 3){
      val percent = (x:Double) => BigDecimal(x * 100)
          .setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
      r(j)  = percent(sum(j).toDouble/n)
      mr(j) = percent(ma(j).toDouble / sum(j))
    }
    (sw: Int) => {
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
  }
  
  val f = output()
  println(f(1))
  println(f(2))
  println(f(3))
  
  

}