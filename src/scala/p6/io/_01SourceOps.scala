package scala.p6.io

import java.net.{URI, URL}

import scala.io.Source

/*
    scala io操作
   首先scala的io，是可以沿用java的io体系
   其次，scala自身的io的核心类就是Source，完成读写操作
 */
object _01SourceOps {
    def main(args: Array[String]): Unit = {
        //读文件
        var lines = Source.fromFile("data/wordcount.txt").getLines().toList
        for(line <- lines) {
            println(line)
        }
        //写文件--->使用java的io流即可
        println("------------------------------------")
        //读取网络文件
        lines = Source.fromURL(new URL("https://www.jd.com/"), "UTF-8").getLines().toList
        for(line <- lines) {
            println(line)
        }
    }
}
