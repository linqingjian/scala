package scala.p2.func

/**
  * scala函数的定义
  * 函数定义时候的注意的点：
  *     1.如果写了函数的返回值类型，=必须要写，不然编译不通过
  *     2.如果没有写函数的返回值类型，=可以省略，其返回值类型为unit，如果有=，则会进行类型推断
  */
object _01FunctionOps {
    def main(args: Array[String]): Unit = {
        val msg = printMsg1("崔浩")
        println(msg)
    }

    def printMsg(name:String):String = {
        s"hello $name"
    }
    def printMsg1(name:String) = {
        s"hello $name"
    }
}
