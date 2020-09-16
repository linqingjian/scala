package scala.p3

import scala.beans.BeanProperty

/*
    scala类的定义
    scala和java一样，都使用关键字class来进行类的声明

    在这里创建的对象就是javabean， java中得这些对象的主要作用是什么
    bean的主要作用就是在各个层之间携带并传递数据
    创建的这些bean一般都只会有字段而很少有相关的方法

    在scala中刚刚创建的这些类，其实是来模拟java中得javabean，在scala中有一个专门的类结构来模拟java中得
    javabean——case class（样例类），会自动的给其中的字段提供getter和setter方法

 */
object _01ClassOps {
    def main(args: Array[String]): Unit = {
        val p:Person = new Person()
        p.setName("吕波")
        p.setAge(18)
        println("name: " + p.getName)
        println("age: " + p.getAge)
        println("----------------------------------")
        val s:Student = new Student()
        s.setName("王羽")
        s.setAge(19)
        s.show()
    }
}

//定义一个scala的类，类名为Person
class Person {

    private var name:String = _ //赋予name默认值，String类型对应的就是null
    private var age:Int = _ //赋予age默认值，Int类型对应的就是null

    //getter setter
    def setName(n:String) = {
        name = n
    }
    def getName = name
    def setAge(a:Int) = {
        if(a < 1) {//这不就是为了保证数据的安全性验证
            throw new RuntimeException("请回娘胎重造去")
        }
        age = a
    }
    def getAge = age
}

//scala使用一个注解为成员变量来自动的提供getter/setter的属性---@BeanProperty
//需要注意的@BeanProperty注解不能和private共存，所以一般也不用
//java中得注解一般都加载方法，类，变量的上面，scala中一般加在前面
class Student {
    @BeanProperty var name:String = _ //赋予name默认值，String类型对应的就是null
    @BeanProperty var age:Int = _ //赋予age默认值，Int类型对应的就是null


    def show(): Unit = {
        println(name + "---->" + age)
    }
}