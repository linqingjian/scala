package scala.p2.collection

/**
  * scala中集合体系之定长数组Array
  *    该数组其实说白了就是java中得数组,但是在操作定义上面又要符合scala的语法特征
  */
object _01CollectionOps {
    def main(args: Array[String]): Unit = {
        //java中数组的定义：int[] a = new int[3];
        val intArr = new Array[Int](3)//()中的3代表的是该数组的长度。 默认值为0
        val strArr = new Array[String](2)//定义了一个长度为2的String类型的数组 默认值为null

        for(i <- intArr) {
            print(i + "\t")
        }
        println
        for(s <- strArr) {
            print(s + "\t")
        }
        println("\n-----------------------------")
        val arr = Array[Int](3)//定义了一个长度为1，初始值为3的数组 --->class 数组Array的伴生对象的构建方式
        for(i <- arr) {
            print(i + "\t")
        }
        println("----------数组的操作----------------")
        //数组赋值 java: arr[index] = xx, scala: arr(index) = xx
        arr(0) = -9
        //获取数组元素
        val value0 = arr(0)
        println("value0: " + value0)
        for(i <- arr) {
            print(i + "\t")
        }
        println("长度")
        //长度
        println(arr.length == arr.size)
        //判断集合元素是否存在
        println(arr.contains(-9))
        println(arr.contains(-1))

        println(arr)

    }
}
