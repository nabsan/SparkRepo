package main.scala.ex.basic

//カリー化のメリットは"簡潔にできる"という点ですが、
//コード量が多少少なくなるだけがメリットと考えられることが多いです。
//実は、既存の関数やメソッドとのインターフェイスの適合性が一番のメリットです。
//引数を1箇所増やすだけでもカリー化されていれば影響が少ない。
//その例を以下に示す。
object PartiallyAppliedFunction4_2  extends App{

  val data = List(
         "501,25,165.0,54.1",
         "502,23,173.5,55.5",
         "503,30,169.2,75.0",
         "504,41,172.6,79.5"
  )

  def parseData(s: String) ={
         val t = s.split(",")
         //println (t(0) + ","+t(1) + ","+t(2) +","+t(3))

         (t(0), t(1).toInt, t(2).toDouble, t(3).toDouble)
  }

  def bmi(t: Double, w: Double, a:Int) ={                       //パラメータaを追加
         val base = if ( a<40) Array(18.5, 25.0, 30.0)         //if文を追加
         else Array(23.0,27.0,30.0)

         val t1 = t* 0.01
         val x = w/(t1*t1)
         //
         if (x < base(0)){
                "やせ型"
         }else if (x < base(1)){
                "普通"
         }else if (x < base(2)){
                "肥満"
         }else{
                "高度肥満"
         }
  }

  def hyouji(code: String, a: Int, t: Double, w: Double, fun: (Double,Double) => String) ={
         printf("-----------")
         printf("社員コード:%s \n", code)
         printf("年齢: %s \n", a)
         printf("身長:%s \n", t)
         printf("体重:%s \n", w)
         printf("判定:%s \n", fun(t,w))
  }

  def test(): Unit ={
         for(s <- data){
                val d = parseData(s)
                val bmiFun = bmi(_: Double, _: Double, d._2)
                hyouji(d._1,d._2,d._3,d._4,bmiFun)               //最小限の変更で収まった！
         }
  }

  test()


}