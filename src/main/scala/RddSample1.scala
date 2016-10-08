package main.scala

import org.apache.spark.SparkContext

object RddSample1 {

  
  def main(args: Array[String]){
    val master = args.length match{
      case x: Int if x > 0 => args(0)
      case _ => "local"
    }
    
    val sc = new SparkContext(master,"RddSample1",System.getenv("SPARK_HOME"))
    //val input = sc.parallelize(List(1,2,3,4))
    //val result = input.fold(0)((x,y) => (x + y))
    //println(result)
    val qRDD = sc.textFile("/Users/manabu/Documents/Spark/ApacheSpark_samples/Chapter5/data/questionnaire.csv")
    .map {record =>
      val splitRecord = record.split(",")
      val ageRange    = splitRecord(0).toInt / 10 * 10
      val maleOrFemale = splitRecord(1)
      val point = splitRecord(2).toInt
      (ageRange, maleOrFemale, point)
    }
    qRDD.collect().foreach(println)
    
    //実処理の例。(2回もRDDが実行される)
    val numQ = qRDD.count
    val totalPoints= qRDD.map(_._3).sum
    println(s"AVG ALL: ${totalPoints/numQ}")
    
    //工夫した実処理の例(上とくらべ、１回だけRDDが実行される)
    val (totalPoints2, numQ2) = qRDD.map(record => (record._3,1)).reduce{
      case ((intermedPoint, intermedCount), (point, one)) =>
           (intermedPoint + point, intermedCount + one)
    }
    println(s"AVG ALL2: ${totalPoints2 / numQ2.toDouble}")
    
    //var sample=qRDD.map(datum => model.predict(datum) + "," + datum.toArray.mkString(",")).sample(false, 0.05)
    
    
    
    	
  }

}