package scala.p3.extendz

/**
  * scala中得继承,使用关键字extends产生继承/扩展关系
  *     1、scala子类覆盖父类的方法是，必须要添加override修饰符，以标识要对父类方法的覆盖，否则认为子类重新创建
  *         一个同名方法，会报错。
  *     2、子类访问父类成员，需要通过关键super来完成
  */
object _01ExtendsOps {
    def main(args: Array[String]): Unit = {
        val p = new Person("王康富", 18)
        p.show()
        println("--------------------")
        val stu = new Student("胡俊华")
        stu.show()

    }
}

class Person {
    var name:String = _
    var age:Int = 13

    def this(name:String, age:Int) {
        this
        this.name = name
        this.age = age
    }

    def show(): Unit = {
        println("person-" + name + "--->" + age)
    }

    def setName(name:String) = this.name = name
}

class Student extends Person {

    def this(name: String) {
        this()
        super.setName(name)
    }
    override def show(): Unit = {
        super.show()
        println("student---")
    }
}
