package scala.p6.implicits

/*
    隐式转换操作
        将一种类型，转化为另外一种类型，而这种操作不是显式的来进行制定，是隐式的操作
    这个隐式转换操作的背后就是通过隐式转换函数来实现的

    什么是隐式转换函数呢？
        一个函数，必须有参数，必须有返回值，其次该函数被implicit关键字修饰。
    常见隐式转换函数的定义格式：
       implicit def source2Target(source:Source):Target = {
         //....
       }
 */
object _01ImplicitsOps {
    def main(args: Array[String]): Unit = {
        val x:Int = 3
        /*
        scala中就有一种，将不可能变成可能的能力
        这种能力就需要隐式转换函数的实现
         */
        val y:Int = 3.5d
        val z:Int = "12345"

        println("x: " + x)
        println("y: " + y)
        println("z: " + z)
    }
    implicit def double2Int(d:Double):Int = d.intValue()
    implicit def str2Int(str:String):Int = str.length
}
