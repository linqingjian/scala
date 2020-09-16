package scala.p2.collection

import scala.collection.mutable.ArrayBuffer

//学习scala中得边长数组ArrayBuffer
object _02CollectionOps {
    def main(args: Array[String]): Unit = {
        //定义类型为Int，有一个初始化长度为3的边长数组
        val arrayBuffer = new ArrayBuffer[Int](3)
        //使用ArrayBuffer的伴生对象定义了一个类型为String的边长数组
        val ab = ArrayBuffer[String]()
        //使用ArrayBuffer的伴生对象定义了一个类型为String的边长数组--->类型推断
        val ab1 = ArrayBuffer("String")

        //////////////crud////////////////
        println(arrayBuffer)
        println(ab1)
        println("增加----------------》")
        arrayBuffer.append(-1)//在该数组的尾部追加一个元素
        println(arrayBuffer)
        arrayBuffer.append(-2, 0, 1)
        println(arrayBuffer)
        println("获取----------------》")
        //获取和定长数组一样，arraybuffer(index)
        val value2 = arrayBuffer(2)
        println("value2: " + value2)
        println("修改----------------》")
        arrayBuffer(2) = 2
        println(arrayBuffer)
        //删除
        println("删除----------------》")
        val deleted = arrayBuffer.remove(1)//删除指定索引位置上的元素，并返回该元素
        println("被删除的元素： " + deleted)
        println(arrayBuffer)
        arrayBuffer.remove(0, 2)//从指定的索引位置开始删除，删除count个元素
        println(arrayBuffer)
        //drop的操作
        arrayBuffer.insert(1, 2, -3, -4, -5, 6)//在指定的索引位置上插入若干个元素
        println(arrayBuffer)
        val newAb = arrayBuffer.drop(2)//从开始删除n个元素，并返回一个新的集合，原集合不便
        println("arrayBuffer：" + arrayBuffer)
        println("newAb：" + newAb)
        println("判断----------------》")
        println("arrayBuffer.contains(4): " + arrayBuffer.contains(4))
        println("长度----------------》")
        println("arraybuffer.length:" + arrayBuffer.size)
    }
}
