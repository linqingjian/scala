package scala.p5.collection

import scala.collection.{SortedMap, mutable}
import scala.io.Source

/*
    集合练习题，统计文件中每一个单词出现的次数

    两种做法：
        传统做法：
        函数式编程的做法
    思路：
        要计算的是每一个单词的次数，所以首先，就要提取每一个单词
        one-2-many的操作--->flatMap

    升级：
    将最后的结果 按照单词的次数降序排列
    如果次数相等，按照单词的字典顺序排列
 */
object _05MapOps {
    def main(args: Array[String]): Unit = {

        val lines:Iterator[String] = Source.fromFile("data/wordcount.txt").getLines()
        val list = lines.toList
        val words = list.flatMap(line => line.split("\\s+"))
        val pairs = words.groupBy(word => word)
                .map(t => (t._1, t._2.size))

        pairs.foreach(println)
        println("------------------------------------")
        pairs.toList.sortWith((kv1, kv2) => kv1._2 > kv2._2)
                    .foreach(println)
        println("—————————————————————————————————————")
        pairs.toList.sorted(new Ordering[(String, Int)](){
            override def compare(x: (String, Int), y: (String, Int)): Int = {
                var ret = y._2.compareTo(x._2)
                if(ret == 0) {
                    ret = x._1.compareTo(y._1)
                }
                ret
            }
        }).foreach(println)
    }
}
