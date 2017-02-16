package main.scala.ex.basic


//カリーingの引数がいつ評価されるか？のプログラム。
//部分適用版(partiallyAppliedFunction.scala)と比較するとわかりやすい。
// カリー版ではその都度評価される事がわかる。
  //部分適用=>評価保留。
  //Curry化=>即時評価

object Currying2  extends App{
   // def main(args: Array[String]): Unit = {println("Hello Scala2")//}
   def kingaku(syouhizei: Double) (nebiki:Double)(tanka: Int)(suuryou: Int) = {
              (tanka * (1.0 - nebiki) * suuryou * (1.0+syouhizei)).toInt
   }

  def tankaFun() ={
    println("--------tankaFun")
    1000
  }
  def suuryouFun() ={
    println("--------suuryouFun")
    6
  }
  def syouhizeiFun() ={
    println("--------syouhizeiFun")
    0.08
  }
  def nebikiFun() ={
    println("--------nebikiFun")
    0.2
  }

  println("----fへの代入開始")
  val f = kingaku(syouhizeiFun())_

  println("------g20への代入開始")
  val g20=f(nebikiFun())

  println("-----------syouhin1nebikiへの代入開始")
  val syouhin1nebiki=g20(tankaFun())

  println("------kへの代入開始")
  val k = syouhin1nebiki(suuryouFun())

  printf("金額=%5d円¥n",k)


}