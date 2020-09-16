package scala.p3

object _03InnerClassOps {
    def main(args: Array[String]): Unit = {
        val outer:Outer = new Outer
        val inner = new outer.Inner()//scala内部类对象的构造方式
        inner.show()
    }
}

class Outer { o => //此时的o代表的就是本类对象引用
    val x = 5

    class Inner { i => //此时的i代表的就是本类对象引用
        val x = 6

        def show(): Unit = {
            val x = 7
            println("x: " + x)
            println("x: " + this.x)//this是本类对象的引用
            println("x: " + i.x)//this是本类对象的引用
            println("x: " + Outer.this.x)//外部类名.this是外部类对象的引用
            println("x: " + o.x)
        }
    }
}
