package scala.p5.func

//scala函数式编程之闭包和柯里化
object _01FunctionOps {
    def main(args: Array[String]): Unit = {
//        clourseOps
        curryingOps
    }
    /*
        柯里化：
            原来的函数有两个参数，def sum(x:Int, y:Int) = x + y,
            现在将sum函数进行改变，只保留一个参数，另外一个参数，作为一个新的匿名函数的参数列表而存在；
            通过该sum函数的函数体就是该匿名函数

            把这个过程称之为柯里化
     */
    def curryingOps: Unit = {
        def sum(x:Int, y:Int) = x + y
        //===>
        def total(x:Int) = (y:Int) => x + y

        println(total(3)(4))
    }

    def clourseOps: Unit = {
        //一个匿名函数，赋值给了前面的一个有参的函数
        def mulBy(factor:Double) = (x:Double) => factor * x

        val triple = mulBy(3.0)
        val half = mulBy(0.5)
        /*
            mulBy的函数体是通过一个匿名函数来实现的
            而该匿名函数(x:Double) => factor * x，需要一个参数x，并没有赋值，所以执行截止triple或者half是不可能拿到结果

           程序执行的过程：
           首先，在代码中定义了两个函数，
            第一个是mulBy
            第二个是匿名函数(x:Double) => factor * x
           其次，执行函数mulBy，并赋值给triple，这样，首先就将factor值赋值成了3.0，
           函数执行完毕之后，不是不是就弹栈；mulBy的实现优势匿名函数。
           再其次，匿名函数(x:Double) => factor * x，压栈，factor是不是就将刚才的3.0保存到了自己的局部变量中
           最后，我们调用它triple(42)的时候，42传递给了x，最终的结果就是42 * 3 = 126.

           在这个过程中，最后，匿名函数调用了一个不在其作用域范围内的变量factor。先弹栈，然后，将factor保存到了匿名函数中，最后
           在匿名函数中调用这个factor。把这种结构，称之为闭包。

           函数可以在变量不再处于作用域内时被调用
         */
        println(triple(42) + "---->" + half(42))
    }

}
