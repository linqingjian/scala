package scala.p3.extendz

//scala受保护的字段
//被protected修饰的字段，只能在子类中被访问
object _03ExtendsOps {
    def main(args: Array[String]): Unit = {
        val 小黄 = new Dog("小黄")
        val 小黑 = new Dog("小黑")

        小黄.makeFriends(小黑)
    }
}

class Animal {
    var name:String = _
    //被protected[this]所修饰的变量，只能被本类，及其子类来访问，但是不能被子类的实例来访问
//    protected[this] var age = 3
    protected var age = 3

    def this(name:String, age:Int) {
        this()
        this.name = name
        this.age = age
    }
    def show(): Unit = {
        println(s"Animal: ${name}, ${age}")
    }
}

class Dog extends Animal {
    age = 5
    def this(name:String) {
        this()
        this.name = name
    }

    def makeFriends(dog: Dog): Unit = {
        println(this.name + " age is " + age + " 和 " + dog.name +
            ", age is " + dog.age + "，交了好朋友")
    }
}
