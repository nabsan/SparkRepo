package main.scala.ex.basic

import javax.xml.parsers.DocumentBuilderFactory

//値渡しと名前渡し
object CallByName4  extends App{
   def loop(cond: => Boolean, update: => Unit)(body: => Unit){
     while(cond){
       body
       update
     }
   }
   
   
   def test1(){
     var a=0;
     loop(a < 3, a += 1){              //完結に表現できている！ var変数 a が全てpointingされているのが味噌。
       println(111)
       println(222)
     }
   }
   
   def test2(){
     //XMLを読み込んでuserタグ要素のコレクションをえる。
     val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
     val doc = builder.parse("data/data.xml")
     
     val users = doc.getElementsByTagName("user")
     var i = 0
     
     loop(i < users.getLength(), i += 1){                 //入れ子loopも完結に表現できている
       var user = users.item(i)
       var node =user.getFirstChild()
       loop(node != null, node=node.getNextSibling){      //同様
         if (node.getNodeName() =="name"){
           println("名前="+ node.getTextContent().replaceAll("¥¥s",""))
         }
       }
     }
   }
   test1()
   test2()
}