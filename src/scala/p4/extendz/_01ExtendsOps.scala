package scala.p4.extendz

/*
    子类覆盖父类的字段:
       只能覆盖被val修饰的变量，不可以覆盖被var修饰的变量

 */
object _01ExtendsOps {
    def main(args: Array[String]): Unit = {
        val zi:Fu = new Zi
        println(zi.name)
        println(zi.age)
    }
}

class Fu {
    val name:String = "zhangsan"
    var age:Int = 13
}

class Zi extends Fu {
    override val name:String = "李四"

}
