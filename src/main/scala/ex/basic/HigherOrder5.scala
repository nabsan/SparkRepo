package main.scala.ex.basic

//HTMLソースをつくりだすプログラム例
object HigherOrder5  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
   val midasi = List(
      List("地域","最高気温","最低気温","降水日数")    
   )
   
   val kisyou = List(
      List("札幌", 12.3, 10.6, 3),    
      List("東京", 18.6, 11.3, 18),    
      List("大阪", 23.0, 14.5, 12),    
      List("福岡", 20.1, 15.2, 15)   
   )
   
   def test1() {
     val funTD= (record: List[Any]) => {
       record.mkString(" <td>", "</td> ¥n <td>" ,"</td> ¥n")
     }
     val funTH=(record: List[Any])=>{
       record.mkString(" <th>", "</th> ¥n <th>", "</th>¥n")
     }
     val funTR =(fun: List[Any] => String,data: List[List[Any]]) =>{
       data.map(fun).mkString(" <tr>","</tr> ¥n <tr>","</tr> ¥n")
     }
     val funTABLE = (midasi: List[List[Any]],data: List[List[Any]]) =>{
       "<table boarder='1'>¥n" +
        funTR(funTH,midasi)+
        funTR(funTH,data)+
        "</table>¥n>"
     }
     println(funTABLE(midasi,kisyou))
   }
   def test2() {
     val funLI= (record: List[Any]) => {
       record.mkString(" <li>", "" ,"</li> ¥n")
     }
   

     
     val funUL =(fun: List[Any] => String,data: List[List[Any]]) =>{
       data.map(fun).mkString(" <ul> ¥n","","</ul> ¥n")
     }
     val funOL = (fun: List[Any]=> String, data: List[List[Any]]) => {
    	data.map(fun).mkString(" <ol> ¥n","","</ol> ¥n")

     }
     println(funUL(funLI,kisyou))
     println(funOL(funLI,kisyou))
   }
   test1()
   test2()
   
   
   
   
  
   
}