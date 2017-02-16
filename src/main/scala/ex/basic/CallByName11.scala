package main.scala.ex.basic

import java.sql.SQLException

//値渡しと名前渡し
object CallByName11  extends App{



  def dbloop(file: String, sql:String)(bodyFun: =>(Map[String,Any])=> Unit){
    val db = new Database
    try{
      db.open(file)
      val rs = db.query(sql)
      val meta=rs.getMetaData()
      val col = meta.getColumnCount()
      val names = for(i <-1 to col) yield meta.getColumnName(i)
      while(rs.next()){
        val map = (for (i <- 1 to col) yield (names(i-1), rs.getObject(i))).toMap
        bodyFun(map)
      }
      rs.close()
    }catch{
      case e : SQLException => println("Error:"+ e.getMessage)
    }finally{
      db.close()
    }

  }
  def test1(): Unit ={

    dbloop("db1.sqlite", "select * from 商品テーブル"){
      rs =>
        printf("%-5s¥t%-15s¥t%5d¥n", rs("商品コード"),rs("商品名"),rs("価格"))
    }
  }


  test1()

}