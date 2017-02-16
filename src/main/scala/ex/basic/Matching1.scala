package main.scala.ex.basic

case class Animal(kind: String){}

//ケースクラスを用いたパターンマッチングの例
object Matching1  extends App{


  def test1(x: Any)= {
      x match{
        case Animal("Cat") => println ("My Dear Cat..")
        case Animal(a) => println ("This is a " + a)     //aを参照できる！
        case _ => println("unknown..")
      }
  }
  val p1 = new Animal("Cat")
  val p2 = new Animal("Dog")
  test1(p1)
  test1(p2)











}