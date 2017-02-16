package main.scala.ex.basic

object Currying  extends App{
   // def main(args: Array[String]): Unit = {println("Hello Scala2")//}
       def kingakuCurried(syouhizei: Double) (tanka: Int)(suuryou: Int) = {
              (tanka * suuryou * (1.0+syouhizei)).toInt
       }

       def test1(){
              println("-- 複数の引数リストを持つメソッド呼び出しによる計算")
              val k1 = kingakuCurried(0.08)(1000)(6)
              val k2 = kingakuCurried(0.08)(1300)(5)
              printf("金額1=%5d円 ¥n",k1)
              printf("金額2=%5d円 ¥n",k2)
       }
       def test2(){
              println("-- かりー化呼び出しによる計算")
              val f = kingakuCurried(0.08)_
              val k1 = f(1000)(6)
              val k2 = f(1300)(5)
              printf("金額1=%5d円 ¥n",k1)
              printf("金額2=%5d円 ¥n",k2)
       }
       def test3(){
              println("-- カリー化呼び出しによる計算2")
              val f08=kingakuCurried(0.08)_
              val f10=kingakuCurried(0.10)_
              val syouhin1_08=f08(1000)
              val syouhin2_08=f08(1300)
              val syouhin1_10=f10(1000)
              val syouhin2_10=f10(1300)
              val k1 = syouhin1_08(6)
              val k2 = syouhin2_08(5)
              val k3 = syouhin1_10(6)
              val k4 = syouhin2_10(5)

              printf("金額1=%5d円 ¥n",k1)
              printf("金額2=%5d円 ¥n",k2)
              printf("金額3=%5d円 ¥n",k3)
              printf("金額4=%5d円 ¥n",k4)
       }
       test1()
       test2()
       test3()
}