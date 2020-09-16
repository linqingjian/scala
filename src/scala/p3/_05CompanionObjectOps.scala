package scala.p3

/*

scala中把同一个源文件中相同名词的object结构称之为class的伴生对象，把相同名词的class称之为object的伴生类
object Singleton是class Singleton的伴生对象
class Singleton是object Singleton的伴生类

  伴生对象/类成立的几个前提：
    1.二者必须在同一个.scala源文件
    2.二者名称必须相同
  伴生对象/类的几个特点：
    1.伴生对象可以访问伴生类中非私有成员和私有
    2.通常在伴生对象中要去覆盖一个方法——apply，用于构造伴生类的对象
        比如，Array、ArrayBuffer、Map等等使用伴生对象来创建，其实就是调用的是对应object中得apply方法
      该apply方法的特点：
        1°、返回值是本类引用
        2°、参数列表对应伴生类的构造器的参数列表
    3、有了伴生对象，同时覆盖了apply方法，便给伴生类，提供了一个简化的对象构造方式，即可以省略new关键字
 */
object _05CompanionObjectOps {
    def main(args: Array[String]): Unit = {
        val cc = new CompanionClass()
        println("--------------------------------")
        val cc1 = CompanionClass()
        println("--------------------------------")
        val cc2 = CompanionClass("王霞", 16)
    }
}


class CompanionClass {
    private val x = 6

    def this(name:String, age:Int) {
        this()
        println("name: " + name)
        println("age: " + age)
    }
}

object CompanionClass {

    def apply(): CompanionClass = {
        val cc = new CompanionClass()
        println("伴生对象访问伴生类私有成员x：" + cc.x)
        cc
    }

    def apply(name:String, age:Int): CompanionClass = {
        new CompanionClass(name, age)
    }

}