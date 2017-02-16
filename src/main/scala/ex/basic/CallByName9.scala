package main.scala.ex.basic

import java.sql.{ResultSet, SQLException}

//値渡しと名前渡し
object CallByName9  extends App{



  def test(): Unit ={
    val db = new Database
    try{
      db.open("db1.sqlite")
      val rs = db.query("select * from 商品テーブル")
      while(rs.next()){
        printf("%-5s¥t%-15s¥t%5d¥n", rs.getString("商品コード"),rs.getString("商品名"),rs.getInt("価格"))
      }
      rs.close()
    }catch{
      case e : SQLException => println("Error:"+ e.getMessage)
    }finally{
      db.close()
    }

  }

  test()

}