package scala.homework

import scala.util.control.Breaks._
object HomeWorkTest2 {
    def main(args: Array[String]): Unit = {
        val array = Array(3, -6, 7, 1, 0, 9, 4, 2)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))
        insertSort(array)
        println("排序后的数组：" + array.mkString("[", ", ", "]"))
        //二分查找
        val key = -10
        val index = binarySearch(array, key, 0, array.length - 1)
        println(s"${key}在数组出现的索引位置为:${index}")

        val sum = getSum(array)
        println("sum: " + sum)
    }

    def getSum(array: Array[Int]): Int = {
        if(array.isEmpty) {
            0
        } else {
            array(0) + getSum(array.drop(1))
        }
    }

    def binarySearch(array: Array[Int], key: Int, start:Int, end:Int): Int = {
        val mid = (start + end) / 2
        if(start <= end) {
            if (key < array(mid)) {
                return binarySearch(array, key, start, mid - 1)
            } else if (key > array(mid)) {
                return binarySearch(array, key, mid + 1, end)
            } else {
                return mid
            }
        }

        return -(start + 1)
    }

    def insertSort(array: Array[Int]): Unit = {
        for (i <- 1 until array.length) {
            breakable {
                for (j <- 1 to i reverse) {
                    if (array(j) < array(j - 1)) {
                        swap(array, j, j - 1)
                    } else {
                        break
                    }
                }
            }
        }
    }
    /*
        不使用第三方变量，完成两个int数字的交换
        ^：位运算的操作符，异或运算
        位：就是0或者1的操作
            异或：相同为0，不同为1
            a=3的二进制：0000-0011
            b=5的二进制：0000-0101
            a = a^b =
                0000-0011
                0000-0101
        ---------------------
                0000-0110
            b = a^b
                0000-0110
                0000-0101
        ---------------------
                0000-0011 --->3
            a = a^b
                0000-0110
                0000-0011
        ---------------------
                0000-0101 --->5

     */
    def swap(array: Array[Int], i: Int, j: Int): Unit = {
        array(i) = array(i) ^ array(j)
        array(j) = array(i) ^ array(j)
        array(i) = array(i) ^ array(j)
    }
}
