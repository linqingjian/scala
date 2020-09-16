package scala.p1

/**
  * 使用scala的for循环，来完成前面while的案例
  * 循环完成如下操作:1+...+10
  * java的版本：
  * int sum = 0;
  * for(int n = 1; n <= 10; n++) {
  *     sum += n;
  * }
  * sop(sum)
  * scala的for循环格式：
  * for(变量 <- 集合) {
  *
  * }
  */
object _05ForDemo {
    def main(args: Array[String]): Unit = {
        var sum = 0
        for(i <- 1 to  10) {
            sum += i
        }
        println("sum=" + sum)
    }
}
