package main.scala.ex.basic

import javax.swing.JOptionPane

//値渡しと名前渡し
object CallByName3  extends App{
   //解説
   //test1とtest2は、結果はおなじになるが、
   //test1よりtest2のほうが、制御構造らしい、見栄えの良いコードのように見える。
   //カリー化のテクニックでもでてきた、引数リスト分割のテクニックを使い、可視性のコードを生成できるのが、
   //scalaの魅力でもある。
  
 //横並びの普通の設計
   def loop1(n: Int, body: => Unit) {
     var i = 0
     while(i < n){
       body
       i += 1
     }
   }
   
   //引数リスト分割を行う。
   def loop2(n: Int)(body: => Unit) {
     var i = 0
     while(i < n){
       body
       i += 1
     }
   }
   def test1() {
     println("-----名前渡し")
     loop1(3, {
       println(111)
       println(222)
     })
   }
   
   def test2() {
     println("-----名前渡し+引数リスト分割")   
     loop2(3) {                         //制御構造として見た目が美しい！while文みたい！
       println(111)
       println(222)
     }
   }
   
   
   val r1=test1()
   val r2=test2()
   
   //どちらも結果は同じ。
   println(r1 == r2)
}