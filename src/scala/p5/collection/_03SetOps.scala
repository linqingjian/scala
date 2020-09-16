package scala.p5.collection

import scala.collection.immutable.SortedSet


//scala集合体系之set操作
object _03SetOps {
    def main(args: Array[String]): Unit = {

        val set = Set(2, 0, 1, 2, 3)
        println(set)
        println("-------------有序的set集合----------------")
        val sorted = SortedSet(//按照字符串的字典顺序进行排列
            "abc",
            "abcd",
            "aac",
            "a",
            "abdc"
        )
        println(sorted)
        println("-------------有序的set集合存储自定义对象----------------")
        /*------------>自定义排序
            由于person不具备比较性，或者集合并没有提供比较器，所以编译失败。
            第一种：让元素具备比较性
                java中，就是让该类型实现接口Comparable
                scala中，就是让该类型扩展特质Ordered
                Ordered和Comparable什么关系呢？
                trait Ordered[T] extends Comparable[T] with serializable
            第二种：让集合提供比较器
                java中，就是给集合提供接口Comparator的实现
                scala中，就是给集合提供特质Ordering的实现
                Ordering和Comparator什么关系呢？
                trait Ordering[T] extends Comparator[T] with serializable
             当比较器和比较性遇到一起，比较器比较优先
         */
        val persons = SortedSet(
            new Person("王  羽", 19, 178.5),
            new Person("于  淼", 19, 179.5),
            new Person("段进堂", 18, 188.5),
            new Person("杨  懿", 20, 180.5),
            new Person("赵宝金", 21, 180.5)
        )(new Ordering[Person](){//匿名内部类
            override def compare(x: Person, y: Person): Int = {
                //按照年龄进行降序，相等，按照身高降序
                var ret = y.age.compareTo(x.age)
                if(ret == 0) {
                    ret = y.height.compareTo(x.height)
                }
                ret
            }
        })

        persons.foreach(println)
    }
}

/*
    按照年龄进行升序，相等，按照身高降序
    升序：就是前面的比较后面的
    降序：就是后面的比较前面的
 */
class Person extends Ordered[Person] {
    var name:String = _
    var age:Int = _
    var height:Double = _
    def this(name:String, age:Int, height:Double) {
        this
        this.name = name
        this.age = age
        this.height = height

    }
    override def compare(that: Person): Int = {
        var ret = this.age.compareTo(that.age)
        if(ret == 0) {
            ret = that.height.compareTo(this.height)
        }
        ret
    }

    override def toString: String = {
        this.name + "--->" + this.age + "--->" + this.height
    }
}
