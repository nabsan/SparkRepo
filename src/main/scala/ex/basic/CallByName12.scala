package main.scala.ex.basic

import java.sql.SQLException

//値渡しと名前渡し
object CallByName12  extends App{



  def dbexec(file: String, sql: String) {
    val db = new Database
    try{
      db.open(file)
      db.execute(sql)
      //rs.close()
    }catch{
      case e : SQLException => println("Error:"+ e.getMessage)
    }finally{
      db.close()
    }

  }
  def test(): Unit ={

    dbexec("db1.sqlite", "update 商品テーブル set 価格=2980 where 商品コード=’商品コード’")
    dbexec("db1.sqlite", "insert into  商品テーブル values ('S101','マウスパッド', 500)")
  }


  test()

}