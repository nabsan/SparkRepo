package main.scala.riak

object HelloRiak {
  
import com.basho.riak.client.core.query.Namespace
import org.apache.spark.{SparkContext, SparkConf}
import com.basho.riak.spark._
import org.apache.spark.rdd.RDD

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs._
import java.io.File

  def main(args: Array[String]): Unit = {
  
    val sparkConf = new SparkConf().setAppName("Simple Scala Riak Demo")

    setSparkOpt(sparkConf, "spark.master", "local")
    setSparkOpt(sparkConf, "spark.riak.connection.host", "127.0.0.1:8087")
    //setSparkOpt(sparkConf, "spark.riak.connection.host", "127.0.0.1:10017")


    println(s"hello riak") 
    val sc = new SparkContext(sparkConf)
         
    val data = Array(1, 2, 3, 4, 5)
    val testRDD = sc.parallelize(data)
    testRDD.saveToRiak(new Namespace("kv_bucket_a"))
     
     
    val queryRDD = sc.riakBucket[String](new Namespace("kv_bucket_a")).queryAll()
    //queryRDD.collect().foreach(println) 
    writeCSV("/tmp/bububu" ,queryRDD)
    sc.stop
    println("end")
    
    
  }

  private def setSparkOpt(sparkConf: SparkConf, option: String, defaultOptVal: String): SparkConf = {
    val optval = sparkConf.getOption(option).getOrElse(defaultOptVal)
    sparkConf.set(option, optval)
  }
  
  
  private def writeCSV(csvFilePath: String, countData: RDD[String]): Unit = {
    val tempFileDir = "/tmp/spark_temp"
    FileUtil.fullyDelete(new File(tempFileDir))
    FileUtil.fullyDelete(new File(csvFilePath))

    countData.saveAsTextFile(tempFileDir)
    merge(tempFileDir, csvFilePath)
  }

  private def merge(srcPath: String, dstPath: String): Unit = {
    val hadoopConfig = new Configuration
    val hdfs = FileSystem.get(hadoopConfig)
    FileUtil.copyMerge(hdfs, new Path(srcPath), hdfs, new Path(dstPath), false, hadoopConfig, null)
  }
  

}