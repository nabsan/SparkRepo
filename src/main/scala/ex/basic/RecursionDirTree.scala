package main.scala.ex.basic

import java.io.File

object RecursionDirTree  extends App{

  def dtree(x: Any) : List[Any] ={
    x match {
      case Nil => Nil
      case a:File => a.getName()::dtree(a.listFiles().toList)
      case (a:File)::aa => (if (a.isFile()) a.getName else dtree(a)) :: dtree(aa)
    }
  }

  def pprint(x: List[Any], n: Int =0): Unit ={
    x match{
      case (d::aa) :: bb => println(" " * n + "(" +d)
                            pprint(aa, n+1); pprint(bb,n)
      case f::aa => println("  " * n + f); pprint(aa,n)
      case Nil if (n > 0) => println(" " * (n-1) + ")")
      case Nil =>
    }
  }



  def test(): Unit ={
    val dir = new File("/Users/manabu/Documents/workspace/SparkScalaTest/src/")
    val list = dtree(dir)
    pprint(List(list))
  }

  test()
  //println("----")

}