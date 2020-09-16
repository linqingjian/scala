package scala.p2.func

/**
  * scala几个基本函数
  *     没有返回值的函数
  *     空参函数
  *     单行函数
  *     递归函数
  */
object _02FunctionOps {
    def main(args: Array[String]): Unit = {
       printMsg("新年，给大家拜个晚年啦~")
       showDate()
       val ret = showDate1
       //单行函数
        printSingLine("恭喜发财，红包发起来~")

       val sum = factorial(5)
        println("ret: " + sum)
    }

    /*
        递归函数:
            必须要有结束条件
         在开发过程中，能不用递归函数，就不用递归函数：
            1.递归层级比较深的话，效率比较低，对栈的负载比较大
            2. 容易引发stackoverflowexception
        昨天做了1+。。。+10计算
        今天作业阶乘的计算
            n!=n * (n-1)*....*2*1
            (n-1)! = (n-1)*....*2*1
            ===>
            n! = n * (n-1)!

            1! = 1
     */
    def factorial(n:Int):Int = {
//        if(n <= 1) 1 else n * factorial(n - 1)
        var sum = 1
        for(i <- 1 to n) {
            sum *= i
        }
        sum
    }
    /*
        单行函数 --->函数体只有一行的比较简单的函数
        单行函数一定以加上=进行类型推断和函数签名和函数体的分割
     */
    def printSingLine(msg:String) = println(msg)
    var name = "abc"
    def setName(n: String) = name = n


    //没有返回值的函数
    def printMsg(msg:String){
        println(msg)
    }
    /*
        空参函数，没有参数列表
        在调用的时候，可以省略掉(),前提是在定义的时候有()
        如果在定义的时候没有加(),在调用的时候也不能加()
     */
    def showDate() {
        println(System.currentTimeMillis())
    }

    def showDate1 = {
        System.currentTimeMillis()
    }

}
