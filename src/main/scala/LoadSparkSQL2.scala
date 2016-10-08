package main.scala

import scala.reflect.runtime.universe

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext

object LoadSparkSQL2 {

  case class Dessert(menuId: String, name: String, price: Int, kcal: Int)
  
  def main(args: Array[String]){  
    val master    = "local"
    val conf = new SparkConf()
    val sc = new SparkContext("local","SSQL2",System.getenv("SPARK_HOME"))
    val sqlContext=new HiveContext(sc)
    import sqlContext.implicits._
    val dessertRDD =sc.textFile("/Users/manabu/Documents/Spark/ApacheSpark_samples/Chapter6/data/dessert-menu.csv")
    val dessertDF = dessertRDD.map { record =>
      val splitRecord = record.split(",")
      val menuId=splitRecord(0)
      val name  =splitRecord(1)
      
      val price =splitRecord(2).toInt
      val kcal  =splitRecord(3).toInt
      Dessert(menuId,name,price,kcal)
    }.toDF
    dessertDF.printSchema
    val rowRDD=dessertDF.rdd
    val nameAndPriceRDD = rowRDD.map { row =>
      val name=row.getString(1)
      val price=row.getInt(2)
      (name,price)
    }
    nameAndPriceRDD.collect.foreach(println)
    dessertDF.registerTempTable("dessert_table")

    nameAndPriceRDD.cache()
    //dessertDF.saveAsTable("dtable")
    val numOver300kcalDF=sqlContext.sql(
        "SELECT count(*) as num_of_over_300kcal FROM dessert_table where kcal >= 260")
    numOver300kcalDF.show
    numOver300kcalDF.registerTempTable("DF300")
    //import org.apache.spark.sql.hive.thriftserver._
    //HiveThriftServer2.startWithContext(sqlContext)
    //↑︎を起動すると、sparkのstart-thriftserver.shをたたく必要もない！？

  }
    
    
    
  

}