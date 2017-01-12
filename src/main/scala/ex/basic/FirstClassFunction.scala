package main.scala.ex.basic

object FirstClassFunction  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
   def strMethod(x: Any) = {
     if  (x == null) "" else x.toString()
   }
   
   val strFun = (x: Any) => {
     if (x == null) "" else x.toString()
   }
   
   def  test1(){
     println("\n === 変数に格納できるか ===\n")
     val f = strFun                            //関数オブジェクトは格納可能
     println("f=" + f)
   }
   
   def test2(){
     println("\n === 関数の引数として渡せるか ===\n")
     val higherOrderFun = (fun: Any => String, arg: Any) => {
       fun(arg)
     }
     val m = higherOrderFun(strMethod, "hello")
     val f = higherOrderFun(strFun, "hello")
     println("m=" + m)
     println("f=" + f)
   }
   def test3(){
     println("\n === 関数の戻り値として返せるか ===\n")
     val higherOrderFun2 = () => {
       strFun
     }
     val f = higherOrderFun2()
     println("f=" + f)
   }
   
   def test4(){
     println("\n === 値としての比較ができるか ===\n")
     val strFun2 = (x: Any) => {
       if (x == null) "" else x.toString()
     }
     
     val f= strFun
     println("strFun == strFun : " +(strFun == strFun))
     println("strFun == strFun2 : " +(strFun == strFun2))
     println("strFun == f : " +(strFun == f))
   }
   
   test1()
   test2()
   test3()
   test4()
      
}