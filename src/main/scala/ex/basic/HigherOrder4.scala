package main.scala.ex.basic

//関数を組み合わせて公開関数を呼び出すプログラム例
object HigherOrder4  extends App{
  
   // def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
  
  val seiseki = List (
        List(101, 80, 58, 75),
        List(102, 70, 85, 87),
        List(103, 45, 79, 60),
        List(104, 50, 55, 68)
  )
  
  val f = (data: List[List[Int]], hantei: (Int,Int,Int) => Any, 
                                  hyouji: (Int, Any) => Unit) => {
  
      data.foreach( x => hyouji(x(0), hantei(x(1),x(2),x(3))))
  }
                                  
  val hanteiFun = (x:Int , y: Int, z:Int) => {
     (x + y) / 2 >= 60 && z >= 80 || (x >=80 || y >= 80 || z >= 80)
  }
                                  
  val rankFun = (x:Int , y: Int, z:Int) => {
    val p = (x +y + z ) /3
    if (p >= 80) "A"
    else if (p >= 70) "B"
    else if (p >= 60) "C"
    else "D"
  }
  
  val styleFun1 = (id: Int, result: Any) => {
    println(id +"	"+ result)
  }
  
  val styleFun2 = (id: Int, result: Any) =>{
    println(id + "	" + (if (result ==true) "合格" else "不合格"))
  }
  
  def test1() {
    println("\n === 平均が60 以上で合格 === \n")
    f(seiseki, (x,y,z) => (x + y + z) /3 >= 60, styleFun1)
  }
  
    
  def test2() {
    println("\n === 複合条件による判定 === \n")
    f(seiseki, hanteiFun, styleFun2)
  }
    
  def test3() {
    println("\n === 成績ランクでの評価 === \n")
    f(seiseki, rankFun, styleFun1)
  }
  test1()
  test2()
  test3()
  
}