package scala.p4.extendz

/*
    scala抽象类的操作
    scala中的抽象类也是使用abstract关键字来进行定义；
    同时该抽象类中既可以有抽象方法，也可以有非抽象方法；
    scala中的抽象方法可以省略abstract关键字。

    子类复写父类的抽象方法是可以省略掉override关键字
 */
object _03AbstractOps {
    def main(args: Array[String]): Unit = {
        val bat:Animal = new Bat
        bat.sleep()
        bat.dead()

        val dog:Animal = new Dog

        dog.sleep()
        dog.dead()
    }
}

abstract class Animal {
    var color:String = _
    /*abstract */def sleep()

    def dead(): Unit = {
        println("动物终有一死，或清蒸，或红烧，或爆炒")
    }
}

class Bat extends Animal {
    color = "黑色"

    /*override*/ def sleep(): Unit = {
        println("倒挂金钟，以睡觉~")
    }

    override def dead(): Unit = {
        println("蝙蝠吃的爽，icu躺倒老~")
    }
}

class Dog extends Animal {
    color = "小黄"

    override def sleep(): Unit = {
        println("小狗趴着睡觉")
    }

    override def dead(): Unit = {
        println("小狗是人类的好朋友，千万不要吃，太残忍了~")
    }
}



