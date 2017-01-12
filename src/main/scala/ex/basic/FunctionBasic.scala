package main.scala.ex.basic

object FunctionBasic  extends App{
   def hakodate() {
     println("----- 函館Enter")
     println("----- 函館Exit")
   }
   def asahikawa(){
     println("----- 旭川Enter")
     furano()
     println("----- 旭川Exit")
   }
   
   def sapporo(){
     println("----- 札幌 Exter")
     hakodate()
     asahikawa()
     println("----- 札幌 Exit")
   }
   
   def  furano(){
     println("----- 富良野 Exter")
     println("----- 富良野 Exit")
   }
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
    //}
   sapporo()
}