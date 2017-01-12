package main.scala.ex.basic

object HigherOrder  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
   def sankaku(a: Int, b: Int, c: Int, fun: (Int,Int,Int) => Boolean){
     if (fun(a,b,c)){
       println("yes")
     }else{
       println("no")
     }
   }
   
   println("\n=== 正三角形の判定 ===\n")
   sankaku(3,3,4,(a,b,c) => a == b && b == c)
   sankaku(3,3,3,(a,b,c) => a == b && b == c)
   
   println("\n=== 二等辺三角形の判定 ===\n")
   sankaku(3,3,4,(a,b,c) => a == b || b == c || c == a)
   sankaku(3,3,3,(a,b,c) => a == b || b == c || c == a)
   
   

}