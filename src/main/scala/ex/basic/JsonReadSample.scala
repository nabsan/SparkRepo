package main.scala.ex.basic

import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._

//JSONファイルを開いて、値を取る例。
object JsonReadSample  extends App{
  def fileloop(file: String)(bodyFun: => (String) => Unit) {
    var src: Source = null
    try{
      //val stream = new FileInputStream(file)
      //val json = try {  Json.parse(stream) } finally { stream.close() }

      /////src = Source.fromFile(file)
      //for (line <- src.getLines()){
      //  bodyFun(line)
      //}
      val source: String = Source.fromFile("test2.json").getLines.mkString
      val json = parse(source)
      val map = json.asInstanceOf[JObject].values
      println(map) //=> Map(numbers -> List(1, 2, 3, 4))
      //val a = parse((map get "widget").get.toString)
      //val b = json.asInstanceOf[JObject].values
      println (map get "name")
      println (map get "meas")
      println (map get "lot")
      println (compact(render(json \\ "lot" \\ "title")))

    }catch{
      case e: Exception => println("Error:"+e.getMessage())
    }finally{
      if (src != null) src.close()
    }
  }

  def test1(): Unit ={
    println("json reading")
    fileloop("log.json"){
      line =>
        println(line)
    }
  }


  test1()


}

/**
test2.json
{"name": "nab",
 "datefrom": "1999-11-11",
  "dateto": "1999-12-12",
  "meas": ["aa", "bb" ,"cc"],
  "lot": {
    "title": "Sample Konfabulator Widget",
    "name": "main_window",
    "width": 500,
    "height": 500
  }
}

  **/