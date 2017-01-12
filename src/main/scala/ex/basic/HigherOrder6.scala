package main.scala.ex.basic

import java.util._
import java.text.SimpleDateFormat


//関数を戻り値として返す高階関数
object HigherOrder6  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
	val warekiLoc =new Locale("ja","JP","JP")
	val seirekiLoc=new Locale("us","EN")
	
	def f(fmt: String , wareki: Boolean) ={
	  val df =new SimpleDateFormat(fmt, if (wareki) warekiLoc
	      else seirekiLoc)
	  (dat: Date) => df.format(dat)
	}
	
	val fmtS = f("yy/M/d",false)
	val fmtL = f("yyyy/MM/dd",false)
	val fmtDot =f("yyyy.MM.dd", false)
	val fmtDash=f("yyyy-MM-dd",false)
	val fmtTime=f("yyyy/MM/dd HH:mm:ss",false)
	val fmtWarekiS=f("Gy/M/d",true)
	val fmtWarekiL=f("GGGGyy年M月d日(E)", true)
	val fmtSeirekiL = f("yyyy年M月d日",false)
	val fmtWeek = f("Gyy/M/d(E)",true)
	
	val d = new Date()
	println(fmtS(d))
	println(fmtL(d))
	println(fmtDot(d))
	println(fmtDash(d))
	println(fmtTime(d))
	println(fmtWarekiS(d))
	println(fmtWarekiL(d))
	println(fmtSeirekiL(d))
	println(fmtWeek(d))
	
}