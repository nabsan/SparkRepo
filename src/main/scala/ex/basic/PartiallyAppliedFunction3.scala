package main.scala.ex.basic

object PartiallyAppliedFunction3  extends App{
       val midasi = List(
              List("地域", "最高気温","最低気温","降水日数")
       )
       val kisyou = List(
              List("札幌", 12.3 ,10.6, 3),
              List("東京", 18.6 ,11.3, 18),
              List("大阪", 23.0 ,14.5, 12),
              List("福岡", 20.1 ,15.2, 15)
       )

       def test1(): Unit ={
              val funEach = (tag: String, s1: String, s2: String , r: List[Any])=> {
                     r.mkString("\n"+s1 + "<"+ tag + ">",
                      s2 + "</"+tag+">\n" + s1 + "<"+ tag+">", s2+"</"+tag +">")
              }

              val funTable = (midasi: List[List[Any]], data: List[List[Any]]) => {
                     "<table boarder ='1'>" +
                       funEach("tr", " ", "\n " ,midasi.map(funEach("th"," ","",_)))+
                       funEach("tr", " ", "\n " ,data.map(funEach("th"," ","",_)))+"\n</table>"

              }
              println(funTable(midasi,kisyou))
       }

       def test2(): Unit ={
              val fun=(tag: String, s1: String, s2: String, r:List[Any]) =>{
                     r.mkString("\n"+s1+"<" +tag + ">" , " " ,s2+"</" + tag + ">")
              }
              println(fun("u1","","\n",kisyou.map(fun("li", " ", "", _))))
              println(fun("ol","","\n",kisyou.map(fun("li", " ", "", _))))
       }
       test1()
       test2()

}