package main.scala.ex.basic

//PartiallyAppliedFunction3のCurrying化版。
// カリー化により総合的に記述量を削減できる効果がある。
// 部分適用と、カリー化では評価タイミングに違いがある。
// この例では引数がどれも文字列定数なので、特に結果に影響はないのがポイント。

object Currying3  extends App{
       val midasi = List(
              List("地域", "最高気温","最低気温","降水日数")
       )

       val kisyou = List(
              List("札幌", 12.3 ,10.6, 3),
              List("東京", 18.6 ,11.3, 18),
              List("大阪", 23.0 ,14.5, 12),
              List("福岡", 20.1 ,15.2, 15)
       )

       def test1(){
              val funEach = ((tag: String, s1: String, s2: String , r: List[Any])=> {
                     r.mkString("\n"+s1 + "<"+ tag + ">",
                      s2 + "</"+tag+">\n" + s1 + "<"+ tag+">", s2+"</"+tag +">")
              }).curried
//↑ここにcurriedを追加。
              val funTABLE = (midasi: List[List[Any]], data: List[List[Any]]) => {
                     "<table boarder ='1'>" +
//ここ↓をひとつひとつのかっこに変更↓
                       funEach("tr")(" ")("\n ")(midasi.map(funEach("th")(" ")("")))+
                       funEach("tr")(" ")("\n ")(data.map(funEach("th")(" ")("")))+"\n</table>"

              }
              println(funTABLE(midasi,kisyou))
       }

       def test2(){
              val fun=((tag: String, s1: String, s2: String, r:List[Any]) =>{
                     r.mkString("\n"+s1+"<" +tag + ">" , " " ,s2+"</" + tag + ">")
              }).curried
//ここをcurriedにして↑　、↓ここを↓ひとつひとつのカッコにかえた
              println(fun("u1")("")("\n")(kisyou.map(fun("li")(" ")(""))))
              println(fun("ol")("")("\n")(kisyou.map(fun("li")(" ")(""))))
       }
       test1()
       test2()

}