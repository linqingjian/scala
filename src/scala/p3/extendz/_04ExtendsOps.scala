package scala.p3.extendz

//scala超类的构造过程
object _04ExtendsOps {
    def main(args: Array[String]): Unit = {
        val zi = new Zi(13)
    }
}

class Fu (name:String, age:Int) {

    println("-----Fu primary---constructor")
    def this(name:String) {
        this(name, 13)
        println("-----Fu--this(name:String)--constructor")
    }

}
/*
在scala的辅助构造器的第一行必须要调用本类的主构造器或者是其他辅助构造器
所以，scala子类的辅助构造器是不可能直接调用父类的构造器的
只能是子类的主构造器来调用父类的构造器
 */
class Zi(name:String, age:Int) extends Fu(name) {
    println("-----Zi primary---constructor")

    def this(age:Int) {
        this("张三", age)
        println("-----Zi--this(age:Int)--constructor")
    }
}
