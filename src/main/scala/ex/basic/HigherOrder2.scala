package main.scala.ex.basic

//成績修正プログラム(高階関数を使わないversion)
object HigherOrder2  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
   var koku = Array(50,60,70,45,88,66,49,100,77,60)
   var suu  = Array(40,80,55,75,60,33,56,67,78,99)
   
   def syuusei(d: Array[Int], rate: Float, plusAlpha: Int){
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
         d(i) += plusAlpha
       }
     }
     
     for(i <- 0 to n -1){
       println(juni(i) + "	" + d(i))
     }
   }
   
   println("\n=== 国語の点数修正===\n")
   syuusei(koku, 0.7f , 3)
   println("\n=== 数学の点数修正===\n")
   syuusei(suu , 0.7f , 3)
   
   
   

}