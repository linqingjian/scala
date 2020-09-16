package scala.p4.extendz

//scala中得抽象字段
object _04AbstractOps {
    def main(args: Array[String]): Unit = {
        val az:AbstractFu = new AbstractZi
        println(az.name)
        println(az.age)
    }
}

abstract class AbstractFu {
    //声明了scala中的抽象字段
    /*abstract */val name:String
    //声明了scala中一个var的抽象字段
    var age:Int
}


class AbstractZi extends AbstractFu {
    override val name: String = "小黄"
    /*override*/ var age: Int = 13
}
