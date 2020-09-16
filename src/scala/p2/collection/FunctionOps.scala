package scala.p2.collection

object FunctionOps {
    def main(args: Array[String]): Unit = {
        val v2 = f2 _
        v2("hello")
    }

    def f1(i:Int): Unit = {
        println(i)
    }

    def f2(str:String): Unit = {
        println(str)
        val v1 = f1 _
//        v1(3)
    }
}
