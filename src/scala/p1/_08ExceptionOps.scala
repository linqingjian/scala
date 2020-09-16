package scala.p1

import java.io.FileNotFoundException

import scala.io.Source

/*
    scala中的异常处理
 */
object _08ExceptionOps {
    def main(args: Array[String]): Unit = {
        try {
            //scala中使用Source的类来读文件
            lazy val lines = Source.fromFile("E:/data/spark/data1.txt").mkString
//            println(lines)
            val i = 1 / 0
            val num = Integer.valueOf("12345a")
            println("num: " + num)
        } catch { //scala的模式匹配
            case nfe: NumberFormatException => {
                println(nfe.getMessage)
            }
            case ae: ArithmeticException => {
//                println(ae.getMessage)
                throw new RuntimeException("被除数不能为0~")//抛异常
            }
            case fnf: FileNotFoundException => {
                println(fnf.getMessage)
            }
        }
    }
}
