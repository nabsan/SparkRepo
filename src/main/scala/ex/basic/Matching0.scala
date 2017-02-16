package main.scala.ex.basic

object Matching0  extends App{

  def test1(x: Int)= {
      x match {
             case 1 => "A"
             case 2 => "B"
             case 3 | 4 => "C"
             case _ => "D"
      }
  }

  println(test1(1))

  def test2(x: Any) ={
    x match {
      case 1 => "A"
      case 0.5 => "B"
      case "c" => "C"
      case true => "D"
      case 3 | "e" | false => "E"
      case _ => "F"
    }
  }

  println(test2("e"))

  def test3(x: Any) ={
    x match {
      case a: Int => a+ " is Int"
      case a: String => a+ " is String"
      case a: List[Any] => a + " is List"
      case _ => "a is other"
    }
  }

  println(test3("2"))

  def test4(x: Int, y: Boolean) ={
    x match {
      case a if a >= 90 => "A"
      case a if a >= 80 => "B"
      case a if a >= 60  => "C"
      case 0 if !y => "X"
      case _ => "D"
    }
  }

  println (test4(75, true))
  println (test4(85, true))
  println (test4(0, true))
  println (test4(0, false))









}