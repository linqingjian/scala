package scala.p5.collection

import scala.collection.mutable
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
object _04MapOps {
    def main(args: Array[String]): Unit = {

        val lines:Iterator[String] = Source.fromFile("data/wordcount.txt").getLines()
        val list = lines.toList
        val words = list.flatMap(line => line.split("\\s+"))
        /*
        val pairs:Map[String, List[(String, Int)]] = words.map(word => (word, 1)).groupBy(t => t._1)
        pairs.foreach(t => {
            val word = t._1
            val count = t._2.size
            println(word + "--->" + count)
        })
        */
        val pairs:Map[String, List[String]] = words.groupBy(word => word)
        pairs.foreach(t => {
            val word = t._1
            val count = t._2.size
            println(word + "--->" + t._2.mkString("[", ", ", "]") + "--->" + count)
        })
    }

    def method2(): Unit = {
        val lines:Iterator[String] = Source.fromFile("data/wordcount.txt").getLines()
        val list = lines.toList
        for(line <- list) {
            println(line)
        }
        println("------------------------------")
        val words = list.flatMap(line => line.split("\\s+"))
        //传统做法
        val map = mutable.Map[String, Int]()
        words.foreach(word => {
            /*
            val countOption = map.get(word)
            var count = 1
            if(countOption.isDefined) {//该option有定义，就是Some
                count += countOption.get
            }
            map.put(word, count)
            */
            map.put(word, 1 + map.getOrElse(word, 0))

        })
        for((word, count) <- map) {
            println(word + "--->" + count)
        }
    }
    def method1(): Unit = {
        /*
    scala加载文件中得内容：scala.io.Source
    迭代器一旦指针到了最后，再通过迭代器读取数据，是读取不到的。
 */
        val lines:Iterator[String] = Source.fromFile("data/wordcount.txt").getLines()
        val list = lines.toList
        for(line <- list) {
            println(line)
        }
        println("------------------------------")
        val words = list.flatMap(line => line.split("\\s+"))
        //        words.foreach(println)
        //传统做法
        val map = mutable.Map[String, Int]()
        words.foreach(word => {
            val countOption = map.get(word)
            if(countOption.isDefined) {//该option有定义，就是Some
            val count = countOption.get
                map.put(word, count + 1)
            } else {//None
            val count = 1
                map.put(word, 1)
            }
        })
        for((word, count) <- map) {
            println(word + "--->" + count)
        }
    }
}
