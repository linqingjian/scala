package scala.p1

/*
使用while循环完成如下操作:1+...+10
java的版本：
    int sum = 0;
    int n = 1;
    while(n <= 10) {
        sum += n;
        n++;
    }
    System.out.println(“sum=” + sum);

 */
object _01WhileTest {
    def main(args: Array[String]): Unit = {
        var sum:Int = 0
        var n = 1 //使用类型推断，推出n的数据类型为Int
        while(n <= 10) {
            sum += n
//            n++//scala中得++/--是集合的方法，不是类似于java中得自增或者自减的操作符
            n += 1
        }
        println("sum=" + sum)
    }
}
