package main.scala.riak

object HelloRiak {
  
import com.basho.riak.client.core.query.Namespace
import org.apache.spark.{SparkContext, SparkConf}
import com.basho.riak.spark._
import org.apache.spark.rdd.RDD
import com.basho.riak.client.api.RiakCommand
import com.basho.riak.spark.rdd.connector.RiakConnector
//import com.basho.riak.spark.rdd.RiakFunctions        //やぱこれだなl

import scala.reflect.ClassTag

import com.basho.riak.client.api.commands.indexes.{IntIndexQuery, BinIndexQuery}
import com.basho.riak.client.api.commands.kv.{DeleteValue, StoreValue, FetchValue, ListKeys}
import com.basho.riak.client.api.RiakClient
import com.basho.riak.client.api.annotations.{RiakIndex, RiakKey}
import com.basho.riak.client.core.query.indexes.LongIntIndex
import com.basho.riak.client.core.query.{Location, Namespace, RiakObject}
import com.basho.riak.spark._
import com.basho.riak.spark.util.RiakObjectConversionUtil

import com.basho.riak.spark.writer.{WriteConf, WriteDataMapper, WriteDataMapperFactory}


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
    queryRDD.collect().foreach(println) 
    writeCSV("/tmp/bububu" ,queryRDD)
    
    
     //val ns: Namespace = new Namespace("my_type", "my_bucket");
     //val lk: com.basho.riak.client.api.commands.kv.ListKeys = com.basho.riak.client.api.commands.kv.ListKeys.Builder(ns).build();
     
//    val queryRDD = RiakFactory
       //val conf = RiakConnectorConf(HostAndPort.hostsFromString("1.1.1.1", 8087).toSet, 1, 2, 1000)
//      RiakConnector(sc.getConf).withSessionDo { session => {
         //foreachKeyInBucket(session.unwrap(), new Namespace("default"), (RiakConnector, l: Location) =>{
         //val v = readByLocation[Long](session.unwrap(), l ,null)
         //data = data+ ((l.getKeyAsString,v))
         //println(session.unwrap()  )
        //})
//      }}
    val connector = RiakConnector(sc.getConf)
//    connector.withSessionDo(session =>{
//          val request = new com.basho.riak.client.api.commands.timeseries.Query.Builder(
//            s"""
//              |   CREATE TABLE aaa2  (
//              |       k       SINT64    not null,
//              |       family  VARCHAR   not null,
//              |       ts      TIMESTAMP not null,
//              |       value   VARCHAR,
//              |
//              |       primary key ((k, family, quantum(ts,1,h)), k, family, ts)
//              |   )
//              |
//            """.stripMargin)
//            .build()
//             val response = session.execute(request)
//   })
   connector.withSessionDo(session =>{
          val request2 = new com.basho.riak.client.api.commands.timeseries.Query.Builder(
            s"""
              | show tables
            """.stripMargin)
            .build()
         val response2 = session.execute(request2)
         val itr = response2.iterator()
         while(itr.hasNext()){
           println(itr.next.getPbRow)
         }
         //println(response2.iterator().next().getPbRow)
   })
   
    
    
     //val  lb: ListBuckets = new ListBuckets.Builder("my_type").build();
     //var resp  = client.execute(lb);
     //for (Namespace ns : response)
     //{
     //    System.out.println(ns.getBucketName());
     //}
    
    
    sc.stop
    println("end")
    
    
  }

  def readByLocation[T:ClassTag](riakSession: RiakClient, location: Location, convert:(Location, RiakObject) => T): T ={
    val fetchRequest = new FetchValue.Builder(location).build()
    val response = riakSession.execute(fetchRequest)

    if( response.isNotFound){
      throw new IllegalStateException(s"Nothing was found for location '$location'")
    }

    if( response.getNumberOfValues > 1){
      throw new IllegalStateException(s"Fetch by Location '$location' returns more than one result: ${response.getNumberOfValues} were actually returned" )
    }

    val ro = response.getValue(classOf[RiakObject])
    convert(location, ro)
  }

  def foreachKeyInBucket(riakSession: RiakClient, ns: Namespace,  func: (RiakClient, Location) => Unit): Unit ={
    val req = new ListKeys.Builder(ns).build()
    val response = riakSession.execute(req)

    //response.iterator().foreach( x=> func(riakSession, x) )
    //response.iterator().( x=> func(riakSession,x))
    
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