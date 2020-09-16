package scala.p1

/*
   scala中得循环嵌套，以for循环为例
*****
*****
*****
*****
*****
打印5行5列的正方形
 */
object _06LoopNestDemo {
    def main(args: Array[String]): Unit = {
        for(x <- 1 to 5) {//外循环控制行
            //每一行还需要处理多次，在这里就应该使用内循环进行处理
            for(y <- 1 to 5) {//内循环控制列
                print("*")
            }
            println
        }
        println("-----------打印下三角形-----------")
        /*
            *
            **
            ***
            ****
            *****
         */
        for(x <- 1 to 5) {
            for(y <- 1 to x) {
                print("*")
            }
            println
        }
        println("-----------打印上三角形-----------")
        /*
            *****
             ****
              ***
               **
                *
         */
        for(x <- 1 to 5) {
            for(y <- 1 to 5) {
                if(x > y) {
                    print(" ")
                } else {
                    print("*")
                }
            }
            println
        }
        println("-----------随堂练习题之9*9乘法表----------------")
        for(x <- 1 to 9) {
            for(y <- 1 to x) {
                print(s"${y} * ${x} = ${x * y}\t")
            }
            println
        }
        println("-----------for循环嵌套的另外一种写法----------------")
        for(x <- 1 to 9; y <- 1 to x) {
            print(s"${y} * ${x} = ${x * y}\t")
            if(x == y) {
                println
            }
        }
        println("-----------for循环嵌套的条件写法----------------")
        for(x <- 1 to 9; y <- 1 to 9; if y <= x) {
            print(s"${y} * ${x} = ${x * y}\t")
            if(x == y) {
                println
            }
        }
    }
}
