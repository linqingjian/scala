package scala.p3

//scala中的单例
object _04SingletonOps {
    def main(args: Array[String]): Unit = {
        val s1 = Singleton.getInstance()
        s1.x = 6
        val s2 = Singleton.getInstance()
        println(s1 == s2)
        println("s1.x=" + s1.x)
        println("s2.x=" + s2.x)
    }
}

//scala的class没有静态特性
class Singleton private () {//私有化构造器
    var x = 5
}

object Singleton {
    private val instance = new Singleton()
    def getInstance():Singleton = {
        //本类的实例
        instance
    }
}