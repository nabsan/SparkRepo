package main.scala.ex.basic



object Example1 extends App {
  val watt = 100
  val hour = 3
  val tanka =25.91     //電気料金単価[円/kWh]
  val em = 0.681       //co2排出量
  
  def ryoukin(w: Int , h:Int) ={
    w * 0.001 * h * tanka
  }
  
  def co2(w: Int, h: Int) = {
    w * 0.001 * h * em
  }
  
  println("1ヶ月の電気料金  =" + ryoukin(watt, hour)*30 + "円")
  println("1ヶ月のCO2排出量 ="+ co2(watt,hour)*30 + " [kg]")

}