package main.scala

import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.SparkConf

object LoadSparkSQL {

  case class Dessert(menuId: String, name: String, price: Int, kcal: Int)
  
  def main(args: Array[String]){  
    val master    = "local"
    //val tableName = args(1)
    val conf = new SparkConf()
    
    //val sc = new SparkContext(master, "LoadSSQL", System.getenv("SPARK_HOME"))
    val sc = new SparkContext("local","SSQL",System.getenv("SPARK_HOME"))
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
    dessertDF.saveAsTable("dtable")
    val numOver300kcalDF=sqlContext.sql(
        "SELECT count(*) as num_of_over_300kcal FROM dessert_table where kcal >= 260")
    numOver300kcalDF.show
    //
    val nameAndPriceDF = dessertDF.select(dessertDF("name"),dessertDF("price"))
    nameAndPriceDF.printSchema
    nameAndPriceDF.show
    val selectAllDF = dessertDF.select("*")
    selectAllDF.printSchema
    selectAllDF.show(5)
    
    println("reg table")
    //selectAllD
    //sqlContext.
    //val nameAndDollarDF = nameAndPriceDF.select($"name",$"price" / lit(120.0))
    //nameAndDollarDF.printSchema
    
    
    
    
    
    
    
    //val hiveCtx = new HiveContext(sc)
    //val input = hiveCtx.sql("FROM src SELECT key, value")
    //val r = hiveCtx.sql("show databases")
    //val c = hiveCtx.sql("create database bbbdb")
    
    //println(r.collect.toList)
    //val data = input.map(_.getInt(0))
    //println(data.collect().toList)
  }
    
    
    
  

}