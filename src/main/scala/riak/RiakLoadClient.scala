package main.scala.riak

import com.basho.riak.client.api.RiakClient

object RiakLoadClient {

  def main(args: Array[String]): Unit = {
    val client: RiakClient = RiakClient.newClient("127.0.0.1","hoge")
//    val ns: Namespace =new Namespace("default", "my_bucket")
//    val location: Location = New Location(ns,"my_key")
//
//    val riakObject: RiakObject  = new RiakObject()
//    riakObject.setValue(BinaryValue.create("my_value"))
    
    
//    
//    //結論:Loader(store)を作ろうとしたが、javaのclient だからめんどくせええ。。素直にjavaで作ろうか。。
//    //readだけならscalaでいいけど。。writeはきびしそう。
    
    
    
    
    
    
  }

}