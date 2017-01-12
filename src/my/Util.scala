package my

import scala.reflect.runtime.universe._
import scala.reflect._
import java.io.File
import java.io.FileWriter



object Util {
  
  def typeName[T: TypeTag](obj: T) = typeOf[T]
  
  
  //処理時間測定
  def stopWatchCore(fname: String, msec: Boolean,
      times: Int = 1)(body: => Unit) ={
    var i = 0;
    val start = System.nanoTime()
    while(i < times){
      body
      i += 1
      
    }
    
    val ns = System.nanoTime()
    val s =timeReport((ns - start) / times, msec)
    println(s)
    if (fname != null){
      log(fname, s.replaceAll(" ¥¥[", "¥t[") + "¥r¥n" )
    }
    
  }
  
  def timeReport(ns: Long, useMsec: Boolean)={
    if(useMsec){
      "%7.3f [msec]".format(ns * 0.000001)
    }else{
      "%7.3 [msec]".format(ns * 0.001)
    }
  }
  
  def log(fname: String, s: String){
    val fw: FileWriter = null
    try{
      val fw = new FileWriter(new File(fname), true)
      fw.write(s)
      fw.flush()
    }catch {
      case e: Exception => println("Error: " + e.getMessage())
    }finally{
      if (fw != null) fw.close()
    }
  }
  
  
  

  
  def stopWatch(t: Int=1)                     = stopWatchCore(null, false, t)_
  def stopWatchMsec(t: Int=1)                 = stopWatchCore(null, true, t)_
  def stopWatchToLog(f: String, t: Int=1)     = stopWatchCore(f, false, t)_
  def stopWatchMsecToLog(f: String, t: Int=1) = stopWatchCore(f, true, t)_
  
  var level = 0
  var indicator = "- "
  
  def trace[T](fname: String, arg:Any*)(body: => T): T= {
    println((indicator*level) +fname + "(" + arg.mkString(",") + ")")
    level += 1
    val ret = body
    level -= 1
    println ((indicator*level) + fname + "= " + ret)
    ret
  }
  
  def loop(n: Int)(bodyFun: (Int) => Unit) {
    var i = 0
    while (i < n){
       bodyFun(i)
       i += 1
    }
  }
}