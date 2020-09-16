package scala.p6.io

import scala.util.matching.Regex

/*
    scala中得正则表达式，入口类就是Regex
 */
object _02RegexOps {
    def main(args: Array[String]): Unit = {
//        val regex = new Regex("")
        val regex:Regex = "Scala".r
        val str = "Scala is Scalable and cool"

        println(regex.findFirstIn(str))//匹配第一个出现的内容
        println(regex.findAllIn(str).toList)
        println(regex.replaceAllIn(str, "java"))

    }
}
