package scala.p2.func

/*
    学习scala的可变参数定义
 */
object _04FunctionOps {
    def main(args: Array[String]): Unit = {
        println(add(1, 2, 3, 4))
//        println(add(Array(3, 4, 5, 6)))
        //scala中将数组传递给可变参数的写法
        //需要将数组中得每一个元素提取出来，传递给当前的函数
        println(add(Array(3, 4, 5, 6) : _*))
    }

    //scala的可变参数
    def add(arr: Int*): Int = {
        var sum = 0
        for(i <- arr) {
            sum += i
        }
        sum
    }
//    def add(arr:Array[Int]) = {
//        var sum = 0
//        for(i <- arr) {
//            sum += i
//        }
//        sum
//    }


    def add(a:Int, b:Int) = {
        a + b
    }

}
