package scala.p3



/*
将class Main反编译之后结果如下：
public class Main {
  public void main(String[] args){
    Predef..MODULE$.println("---hello-");
  }
}
这个函数main和传统的主函数有啥区别？是不是少了static
 */
class Main {
    def main(args: Array[String]): Unit = {
        println("---hello-")
    }
}

