package scala.p6.generic

import scala.util.control.Breaks._
/*
    scala版本的泛型方法
    格式：在函数名称和参数列表之间使用[]定义泛型
    学习了scala中得泛型的限定
        上限限定=> T <: 类型  <=> T extends 类型
        下限限定=> T >: 类型  <=> T super 类型
    视图界定：
        T <% 类型
 */
object _02GenericMethodOps {
    def main(args: Array[String]): Unit = {
        val array = Array[Int](3, -6, 7, 1, 0, 9, 4, 2)
        val dArray = Array[Double](3.0, -6.0, 7.0, 1.0, 0.0, 9.0, 4.0, 2.0)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))
        println("排序前的数组：" + dArray.mkString("[", ", ", "]"))
        Tool.insertSort[Int](array)
        Tool.insertSort[Double](dArray)
        println("排序后的数组：" + array.mkString("[", ", ", "]"))
        println("排序后的数组：" + dArray.mkString("[", ", ", "]"))
    }
}

object Tool {
    /*
        Error:(14, 24) type arguments [Int] do not conform to method insertSort's type parameter bounds [T <: Comparable[T]]
        Tool.insertSort[Int](array)
        使用java中得Integer就能够使用排序，但是使用Int就不可以，为什么？
        主要的原因在于，java中得Integer implements Comparable<Integer>
        scala中的Int，并没有扩展Comparable: class Int private extends AnyVal
        所以，在这里就不能直接传入Int类型的数组进行通用排序，
        但是scala中得数据类型就是Int，怎么办？
            scala提供了一种解决方案：
                将T <: 类型这种格式，升级为T <% 类型(把这种格式称之为，视图界定)
        通过视图界定这种语法结构，对Int类型进行扩展，增强了Int的能力，这样就可以让Int具备Comparable的能力，
        实际上，在这内部起作用的就是下午要给大家来讲解的隐式转换，其实质是将Int 转化位RichInt，而RichInt扩展了Ordered extends Comparable
     */
    def insertSort[T <% Comparable[T]](array: Array[T]): Unit = {
        for (i <- 1 until array.length) {
            breakable {
                for (j <- 1 to i reverse) {
                    if (array(j).compareTo(array(j - 1)) > 0) {
                        swap(array, j, j - 1)
                    } else {
                        break
                    }
                }
            }
        }
    }

    def swap[T](array: Array[T], i: Int, j: Int): Unit = {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
    }


}
