package scala.p2.collection

//scala元组之tuple
//tuple的长度，最大是22
object _06TupleOps {
    def main(args: Array[String]): Unit = {
        var t:Tuple1[String] = new Tuple1[String]("abcdefg")//太啰嗦，不用
        val t1:String = ("iloveyoubaby")//()中只有一个元组的时候，不是一个tuple，就是对应()的值
        println(t1)

        val t3:Tuple3[Int, Double, String] = (1, 2.4, "hello")
        //获取tuple中得元素值
        val first = t3._1
        val second = t3._2
        val third = t3._3
        println(first + "-->" + second + "--->" + third)
        //遍历tuple集合 不能直接进行遍历，需要产生对应的迭代器iterator才可以进行遍历
        for(tt <- t3.productIterator) {
            println(tt)
        }
        println("---------------tuple定义时的简写方式----------------------")

        val (spring, summer, autumn, winter) = ("spring", "summer", "autumn", "winter")
        println(spring)
        println(summer)

    }
}
