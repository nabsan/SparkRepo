package main.scala

import org.apache.spark.SparkContext

object HelloSpark {

  	def  main(args:  Array[String]) {
		
  	    println("hello")
  	    val logFile="/usr/local/spark/spark-1.6.2-bin-hadoop2.6/README.md"
		val sc = new SparkContext("local","HelloSpark",System.getenv("SPARK_HOME"))
  	    val logData=sc.textFile(logFile).cache()
  	    
        //val input = sc.parallelize(List(1,2,3,4))
        //val result = input.fold(0)((x,y) => (x + y))
		
		val cnta=logData.filter(_.contains("a")).count()
		val cntb=logData.filter(_.contains("b")).count()
		
		println("Lines with a: "+ cnta + ", lines with b:"+cntb)
		println("end")
		

		


	}
}