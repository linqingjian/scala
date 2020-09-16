package scala.p3

/*
    scala对象的构造之构造函数
    scala的构造器并不想java的一样，使用类名来定义。

    scala的默认构造器在类名后面和{前面之间被定义，把这个构造器又称之为scala的主构造器。
    scala的构造器有主构造器和辅助构造器之分。
    主构造器就是类名后面和{前面之间被定义的本分，()中便是主构造器的参数列表，可以为空，为空时可以省略(),
    {}类体，一方面来定义类的各个成员，另一方面又是主构造器的函数体。
    scala的辅助构造器的定义，是使用关键字this来替换java中的类名的。注意，在定义辅助构造器的时候一定要记清楚：辅助构造器的第一句话
    必须要调用主构造器或者其他辅助构造器。这句话的本质，辅助构造器归根到底要从主构造器调用开始。
 */
object _02ClassOps {
    def main(args: Array[String]): Unit = {
        val t = new Teacher()
        t.show()
        println("---------辅助有参构造器--------------")
        val t1 = new Teacher("李德胜", 38)
        t1.show()
        println("---------复杂构造器--------------")
        val t2 = new Teacher1()
        t2.show()
        println("---------构造器私有化--------------")
        val t3 = new Teacher1("韦超", 23)
        t3.show()
    }
}

class Teacher() {
    private var name:String = _
    private var age:Int = _
    println("这是scala的默认构造器吗---主构造器")
     def Teacher(): Unit = {//经过实践证明，这不是scala的构造器
        println("这是scala的默认构造器吗？")
    }
    def this(name:String, age:Int) {//辅助构造器
        this()//调用其它构造器使用this关键字
        this.name = name
        this.age = age
        println("这是scala的辅助有参构造器")
    }

    def setName(n:String) = name = n
    def getName = name
    def setAge(a:Int) = age = a
    def getAge = age
    def show(): Unit = {
        println(name + "---->" + age)
    }
}
/*

scala中哪怕你用private修饰了，也可以构造对象，但需要稍微的变化一下下
需要给private添加访问范围,格式如下：private[包名]
    当前被修饰的成员，只能在该包，及其子包下面被访问
所以：scala中不加private或者protected就是public
 */
class Teacher1 private[p3] (
          name:String,
          age:Int) //有参主构造器
{
    println("------------这是有参主构造器-----------")

    def this(name:String) {
        this(name, 13)
        println("-----------this(name:String)-------------")
    }

    def this() {
        this("安依飞")
        println("-----------this()-------------")
    }

    def show(): Unit = {
        println(name + "---->" + age)
    }
}
