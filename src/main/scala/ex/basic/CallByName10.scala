package main.scala.ex.basic

import java.sql.{ResultSet, SQLException}

//値渡しと名前渡し
object CallByName10  extends App{



  def dbloop(file: String, sql:String)(bodyFun: =>(ResultSet)=> Unit){
    val db = new Database
    try{
      db.open(file)
      val rs = db.query(sql)
      while(rs.next()){
        bodyFun(rs)
      }
      rs.close()
    }catch{
      case e : SQLException => println("Error:"+ e.getMessage)
    }finally{
      db.close()
    }

  }
  def test1(): Unit ={
    println("------データベース表示----")
    dbloop("db1.sqlite", "select * from 商品テーブル"){
      rs =>
        printf("%-5s¥t%-15s¥t%5d¥n", rs.getString("商品コード"),rs.getString("商品名"),rs.getInt("価格"))
    }
  }

  def test2(): Unit ={
    println("------データベース表示 価格で照準ソートver----")
    dbloop("db1.sqlite", "select * from 商品テーブル order by 価格"){
      rs =>
        printf("%-5s¥t%-15s¥t%5d¥n", rs.getString("商品コード"),rs.getString("商品名"),rs.getInt("価格"))
    }
  }

  test1()

}