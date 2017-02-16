package main.scala.ex.basic

import javax.swing.JOptionPane

//値渡しと名前渡し
object CallByName  extends App{
   //解説：
   //値渡しは通常のやつで、"評価した値を渡す"。
   //名前渡しは、"評価しないまま渡す。(実際に利用されるときに遅延評価される)"。
   //プログラム構造として、呼び出される側は一つで、呼び出し側が多数の場合がよくある。この場合、
   //呼び出し側でパラメータを前もって調整するロジックを書くことになるが、、呼び出される(ひとつの)　側で
   //ifで式を記述したほうが、コード行数もへり、可読性も上がる。生産性も上がる！！
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
  var data = Array(50,60,70,45,88,66,49,100,77,60)
  
  def getDataCount()={
    data.length
  }
  //val japanese =true
  val japanese =false
  
  def messageBox(jp: String, en: String){  //渡される時点で２つとものパラメータが整形処理されてる(片方は無駄)。
    println("----msgbox 値渡しver---")
    JOptionPane.showMessageDialog(null, if (japanese) jp else en,
         "test", JOptionPane.INFORMATION_MESSAGE)
  }
  def messageBoxByName(jp: => String, en: => String){    // "=>"がはいると名前渡し。
    println("----msgbox 名前渡しver---")
    JOptionPane.showMessageDialog(null, if (japanese) jp else en,
         "test", JOptionPane.INFORMATION_MESSAGE)
  }
  
  def test1(){
    println("値渡しと名前渡し")
    messageBox(getDataCount()+"件のデータを読み込みました"," Loaded" + getDataCount() +" Data.")
    messageBoxByName(getDataCount()+"件のデータを読み込みました"," Loaded" + getDataCount() +" Data.")
  }
  
  def test2(){
    println("値渡し実験")
    messageBox(jpn(),en())
    
    println("名前渡し実験")
    messageBoxByName(jpn(),en())
  }
  
  def jpn()={
    println("----jpn")
    getDataCount() + "件のデータを読み込みました。"
  }
  
  def en()={
    println("----en")
    "Loaded.. "+getDataCount() + " Data."
  }
  test1()
  test2()
  
  
  
}