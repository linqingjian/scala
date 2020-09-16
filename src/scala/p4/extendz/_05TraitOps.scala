package scala.p4.extendz

/*
    scala中的特质Trait
    首先什么事特质？
        特质trait，就是在scala中一种和class、object同一级别的语法结构，需要被trait关键字进行声明。
    为什么要有这个trait特质？
        java和scala继承的特点？
            不仅仅指的是：封装、继承、多态、抽象。
            只能单继承，不可以多继承！
        这种单继承，是由局限的，只能单一的继承某一个类的成员，在scala和java中是无法做到再去继承其它类的特性。
        为了弥补这个缺陷，在scala和java中，首先都有多层继承。
            A extends B，B extends C <=> A同时继承了B和C的特性，
        其次在java中是不是就有了(多)实现的概念，被实现的结构称之为接口（interface），接口中得所有的方法都必须是抽象。

    ？？？ java中多实现的方法都是抽象，需要自己要实现这些方法

    于是乎，在scala中就弥补了这个缺憾，java中多实现的方法都、需要自己要实现。那也就是说，在scala中是可以多实现的，
    同时，多实现的方法不一定是抽象的。

    scala把类似java中得这种多实现接口(interface)，不叫多实现，叫对trait特质的多扩展。
    scala中得trait在一定程度上，是可以看做java中得接口interface的
        所以如果一个trait中得所有方法都是抽象的，就可以将它视为是一个java中得接口。

    在java中，实现多个接口的时候，使用关键字implements来实现，多个使用","来进行分割
    在scala中，扩展特质trait和扩展父类使用相同的关键字extends，扩展多个trait使用with关键来进行分割
        而且，如果既继承一个类，有扩展一个特质，书写顺序是继承类优先，其次再with 特质
 */
object _05TraitOps {
    def main(args: Array[String]): Unit = {
        val cl = new ConsoleLog with TraitMix
        cl.show()
        cl.log("行车不规范，亲人泪两行")
        cl.method()

        cl.mix()
    }
}

class TraitFu {
    def method(): Unit = {
        println("--TraitFu--method")
    }
}

trait TraitMix {
    def mix(): Unit = {
        println("这是一个混入的方法")
    }
}


trait Log {
    def log(msg:String)
    def show(): Unit = {
        println("这就是为了证明，scala中得trait比java中得interface更加的NB Plush")
    }
}

class ConsoleLog extends TraitFu with Log with Serializable {
    def log(msg: String): Unit = {
        println("控制台：" + msg)
    }
}

class FileLog extends Log {
    override def log(msg: String): Unit = {
        println("文件： " + msg)
    }
}
