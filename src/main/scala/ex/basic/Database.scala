package main.scala.ex.basic

import java.sql.{DriverManager, Connection, Statement, SQLException}

class Database {

       private var con: Connection = null
       private var st: Statement = null

       def connect(dbname: String, user: String, pass: String) ={
              DriverManager.getConnection("jdbc:sqlite:" + dbname,user,pass)
       }

       def open(dbname: String, user: String ="", pass: String=""): Unit ={
              con = connect(dbname, user ,pass)
              st = con.createStatement()
       }

       def close(): Unit ={
              try{
                     try{
                            if (st != null){
                                   st.close()
                                   st = null
                            }
                     }catch{
                            case e: SQLException => println("Error:" + e.getMessage())
                     }
                     if (con != null){
                            con.close
                            con = null
                     }
              }catch{
                     case e: SQLException =>println("Error:" + e.getMessage)
              }
       }

       def query(sql : String) ={
              st.executeQuery(sql)
       }

       def execute(sql: String) = {
              st.executeUpdate(sql)
       }
}