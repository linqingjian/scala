package scala.p5.collection

//scala的集合体系再学习
object _01ListOps {
    def main(args: Array[String]): Unit = {
        val list = List(3, -6, 7, 1, 0, 9, 4, 2)
        //三个基本方法head，isEmpty，tail
        val first = list.head
        val isBlank = list.isEmpty
        val others = list.tail
        println("first: " + first)
        println("isBlank: " + isBlank)
        println("others: " + others)
        //通过递归方式，来求解数组元素的和。
        val sum = getTotal(list)
        println("sum: " + sum)
    }

    def getTotal(list: List[Int]):Int = {
        if(list.isEmpty) {
            0
        } else
            list.head + getTotal(list.tail)
    }
}
