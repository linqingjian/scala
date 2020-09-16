package scala.p6.implicits

import java.io.File

import scala.io.Source
/*
    隐式转换功能之丰富现有api的功能
    让java.io.File类具备读写文件的能力

    在java中我们要向实现这个功能怎么办？
    装饰设计模式
    一个比较经典的案例：BufferedReader和LineNumberReader
 */
object _02ImplicitsOps {
    def main(args: Array[String]): Unit = {
        val file:File = new File("data/wordcount.txt")
        val filename = file.getName
        println("filename: " + filename)
        println("------------file.read----------->")

        val lines: List[String] = file.read()
        lines.foreach(println)
    }

    implicit def file2RichFile(file:File): RichFile = {
        new RichFile(file)
    }
    //RichFile 没有 需要我们自己进行构造
    class RichFile(file: File) {
        def read(): List[String] = {
            Source.fromFile(file).getLines().toList
        }
    }
}
