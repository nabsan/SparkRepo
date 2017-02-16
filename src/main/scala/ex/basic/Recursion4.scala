package main.scala.ex.basic

object Recursion4  extends App{

  val data = List(7,8,2,3,4,9,10,5,1,6)

  def proc(x:List[Int],fun: (Int,Int) => Int): Int = {
    if (x.tail == Nil) x.head                  //繰り返しの終了処理
    else fun(x.head, proc(x.tail,fun))          //"再帰の結果の最後に、先頭を追加する”という処理となる。
  }

  def proc_dbg(x:List[Int],fun: (Int,Int) => Int): Int = {
    my.Util.trace("proc",x,fun) {
      if (x.tail == Nil) x.head //繰り返しの終了処理
      else fun(x.head, proc_dbg(x.tail, fun)) //"再帰の結果の最後に、先頭を追加する”という処理となる。
    }
  }


  def test(): Unit ={
    val sum = proc(data, (a,b) => a+b)
    val max = proc(data, (a,b) => if(a>b) a else b)
    val min = proc(data, (a,b) => if (a<b) a else b)
    println("sum="+sum)
    println("max="+max)
    println("min="+min)

    val sum2 = proc_dbg(data,(a,b) => a+b)
    val max2 = proc_dbg(data,(a,b) => if (a>b) a else b)

  }

  test()
  //println("----")

}