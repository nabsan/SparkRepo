package main.scala.ex.basic

//プログラムの発展検討
object HigherOrder2_5  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
   var koku = Array(50,60,70,45,88,66,49,100,77,60)
   var suu  = Array(40,80,55,75,60,33,56,67,78,99)
   
   //def syuusei(d: Array[Int], rate: Float, plusAlpha: Int){
   def syuusei(d: Array[Int],mode: Int, rate: Float, plusAlpha: Float){
     val n = d.length
     val juni = new Array[Int](n)
     
     for(i <- 0 to n -1){
       juni(i) = 1
     }
     for(i <- 0 to n -1){
       juni(i) =1
     }
     for(i <- 0 to n -1){
       for (j <- 0 to n -1){
         if (d(j) < d(i)) juni(j) += 1
       }
     }
     
     //点数修正処理
     for(i <- 0 to n -1){
       if (juni(i) > n * rate){
         //d(i) += plusAlpha
         d(i) +=  Math.round(d(i) * plusAlpha)
         if (mode == 1){
           d(i) += plusAlpha.toInt
         } else if (mode == 2){
           d(i) += Math.round(d(i) * plusAlpha)
         }
       }
     }
     
     for(i <- 0 to n -1){
       println(juni(i) + "	" + d(i))
     }
   }
   
   println("\n=== 国語の点数修正===\n")
   syuusei(koku,1, 0.7f , 3)
   println("\n=== 数学の点数修正===\n")
   syuusei(suu, 2, 0.7f , 0.15f)
   
   
   

}