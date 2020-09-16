package scala.p2.collection

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * 数组的通用操作
  */
object _03CollectionOps {
    def main(args: Array[String]): Unit = {

        val array = Array(1, -2, -3, 4, -5, 6)//使用Array的半生对象创建一个Int类型的数组，其初始值为1-6

        //将数组---》可变数组
        val buffer = array.toBuffer

        //可变数组 ----> 数组
        val arr = buffer.toArray

        //集合的遍历
        //方式一：使用普通的for循环
        println("===使用普通的for循环===")
        for(i <- array) {
            println("i: " + i)
        }
        //方式二：使用foreach操作,foreach是该集合本身的一个函数
        println("===使用foreach操作===")
        buffer.foreach(i => println("i: " + i))

        //集合转化为字符串
        println(array)//[I@12354 --->Arrays.toString()
        println(util.Arrays.toString(array))
        //scala提供了一个更加灵活的函数mkString，将集合转化为自定义格式的String
        println(array.mkString)//将集合中得所有元素连接起来
        println(array.mkString(","))//使用分隔符","将集合中得所有元素连接起来
        println(array.mkString("{", "-", "}"))//使用分隔符"-"将集合中得所有元素连接起来,同时添加起始和终止符
        //求和
        println("------数组求和-------")
        var ret = 0
        for(i <- array) {
            ret += i
        }

        println("sum=" + ret)
        ret = array.sum
        println("ret=" + ret)
        println("------求集合的最值-------")
        var max = array(0)
        for(i <- array) {
            if(max < i) {
                max = i
            }
        }
        println("max: " + max)
        ret = array.max//array.min
        println("max: " + ret)
        //集合排序
        println("------对集合排序-------")

        val sortedArr = array.sorted//对集合使用升序进行排序，并返回排序后的集合，原集合不便
        println(array.mkString(","))
        println(sortedArr.mkString(","))

    }
}
