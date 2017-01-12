package main.scala.ex.basic

object MethodAndFunction  extends App{
  
  //methodの定義（オブジェクト指向プログラミングによるオブジェクト内で定義される関数のことをメソッドという）
  //
  def bmiMethod(t: Double, w: Double) = {
    val t1 =t* 0.01
    w / (t1 * t1)
  }
  //混乱するのは省略形が出てきたとき。
  //省略ルールを理解してみることが大事。
  //1. scalaは静的型付けなので、通常データ型明示は必須。
  //  本来) def bmiFunction (t:Double, w: Double):Double = {
  //  省略) def bmiMethod(t:Double, w: Double) = {   #最終行が Double値の掛け合わせのため、返り値は省略できる!
  
  
  //関数オブジェクト定義(名前の横のイコールが)
  def bmiFunction = (t: Double, w: Double)=>{
    val t1 = t* 0.01
    w / (t1 * t1)
  }
  //混乱するのは省略形が出てきたとき。
  //省略ルールを理解してみることが大事。
  //2. 本来)val bmiFunction: (Double, Double) => Double = (t,w) => {
  //   省略)val bmiFunction =(t:Double, w:Double) => {    #関数名の引数の型が省略されたが、どっちみちtとwの型は明示すべきなので、そちらで明示。tとwの掛け算である戻り値は省略できた。
  //省略形についてまとめると、型推論可能な場合のみが省略できる！
  
  def test() {
    val m = bmiMethod(165, 55)
    val f = bmiFunction(165,55)
    println("BMI(Method)=" + m)
    println("BMI(Function)=" + f)
    
  }
  
  test()
  
  
  
   // def main(args: Array[String]): Unit = {
       //println("Hello Scala2")
   //}

}