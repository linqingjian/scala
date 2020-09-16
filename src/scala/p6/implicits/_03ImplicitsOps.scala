package scala.p6.implicits

import java.io.File

import scala.io.Source

/*
    隐式转换的引入
        隐式转换的引入，有点类似于导包，这是其一
        其二，只需要将我们的该隐式转换引入到相关变量的作用域范围内即可
        其三，则该变量就会自动在其作用域范围内去检索被implicit关键字修饰的函数
        其四，当找到implicit对应的函数有多个的时候，就会根据自己的类型和返回值的类型，进行匹配，
            以此来确定到底要使用哪一个隐式转换
     注意：只需要我们导入，不需要进行强制的指定
 */
import _02ImplicitsOps.file2RichFile//不建议在这里导入隐式转换
object _03ImplicitsOps {
    def main(args: Array[String]): Unit = {
        val file:File = new File("data/wordcount.txt")
        val filename = file.getName
        println("filename: " + filename)
        println("------------file.read----------->")
        import _02ImplicitsOps.file2RichFile//建议在局部引入，这样影响最小
        val lines: List[String] = file.read()
        lines.foreach(println)
    }
}
