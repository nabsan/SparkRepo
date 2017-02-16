package main.scala.ex.basic

//関数引数の部分適用の引数評価順を調べるプログラム
 //部分適用の部分では評価されず、実際にはじめて利用されるときに評価されます。
  //->currying2.scalaと比較してみると異なる特徴がよくわかる。Currying2ではその都度評価されている。
     //部分適用=>評価保留。
     //Curry化=>即時評価
object PartiallyAppliedFunction2  extends App{

   def kingaku (tanka: Int, suuryou: Int, syohizei: Double, nebiki: Double) ={
          (tanka * (1.0 - nebiki) * suuryou * (1.0 + syohizei)).toInt
   }


   def tankaFun() ={
          println("---- tankaFun")
          1000
   }

   def suuryouFun()={
     println("-----suuryouFun")
     6
   }

   def syohizeiFun() = {
     println("----syouhizeiFun")
     0.08
   }

  def nebikiFun() = {
    println("----- nebikiFun")
    0.2
  }

  println("----------fへの代入開始")
  val f=kingaku(_: Int, _: Int, syohizeiFun(), _: Double)

  println("-------g20への代入開始")
  val g20= f(_: Int, _: Int, nebikiFun())

  println("--------kへの代入開始")
  val k: Float = g20(tankaFun(), suuryouFun())

  printf("金額= %5f 円",k)


}