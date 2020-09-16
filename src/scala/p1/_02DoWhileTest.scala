package scala.p1

/*
使用do...while循环完成如下操作:1+...+10
   int sum = 0;
   int n = 1;
   do {
      sum += n;
      n++;
   } while(n <= 10)
   System.out.println(“sum=” + sum);

 */
object _02DoWhileTest {
    def main(args: Array[String]): Unit = {
        var sum = 0
        var n = 1
        do {
            sum += n
            n += 1
        } while(n <= 10)
        println("sum= " + sum)
    }
}
