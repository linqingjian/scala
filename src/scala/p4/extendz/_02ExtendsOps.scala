package scala.p4.extendz

/*
匿名子类？
    没有名字的子类
通常出现在继承体系中，对于接口 抽象类只用一次的情况。
同时父类中得抽象方法相对比较少。

class Xxx{} -->这不是匿名，

匿名子类 new Xxx(){}

作用：方法参数

 */
object _02ExtendsOps {
    def main(args: Array[String]): Unit = {
        val person:Person = new Person(){
            override def show(): Unit = {
                super.show()
                println("我们在春暖花开之时，等待英雄凯旋而归~")
            }
            def study(): Unit = {
                println("good good study, day day up~")
            }
        }


//        person.show()
//        person.study()

        showPerson(new Person(){
            override def show(): Unit = {
                super.show()
                println("我们在春暖花开之时，等待英雄凯旋而归~")
            }
        })
    }


    def showPerson(person:Person): Unit = {
        person.show()
    }
}

class Person {
    val name:String = "我们都是武汉人，我们为武汉加油"

    def show(): Unit = {
        println(name)
    }
}

class Student extends Person {

}

