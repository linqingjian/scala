package scala.p3

/*
    在java的一个类中，既可以有static，也可以有非static的成员，同时java的主函数必须是static
    但是scala中得class结构只能提供非static的成员，所以要想给scala也提供static的成员，就必须要使用object的结构
    这个大家可以通过反编译来分析出来。

    在scala的object中定义的成员都是类似于java中得静态成员，也就是直接可以通过类名.调用，无需创建对象

 主要的作用：
 ​	1.给scala类提供程序运行的入口，静态的main函数
​	2.给scala类也来提供静态成员——scala类的伴生对象来实现。
 */
object _03ObjectOps {
    def main(args: Array[String]): Unit = {
        println("---hello-")
    }
}
