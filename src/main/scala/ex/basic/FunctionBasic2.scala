package main.scala.ex.basic

/**
 * 距離と角度から、座標を求める関数の例
 */
object FunctionBasic2  extends App{
    def rad(a: Double) = {
      a * 3.141592 /180.0
    }
    
    def pointX(r: Double, a: Double) ={
       r * math.cos(a)
    }
    
    def pointY(r: Double, a: Double) = {
      r * math.sin(a)
    }
    
    def display(x: Double, y:Double){   //"="がついてないのでvoid関数（戻り値ナシ）となる
      println(x + " , " + y)
    }
    
    def test(){
      display(pointX(5.5, rad(30.0)), pointY(5.5, rad(30.0)))
    }
    test()
    
}