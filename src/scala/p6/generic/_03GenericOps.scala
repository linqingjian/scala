package scala.p6.generic

/**
  * scala泛型特点：
  *     在默认情况下，scala的泛型，在“=”左右两侧也必须是相等的，不能出现左右两侧是继承关系的。
  *     同样，可以通过+/-T,来实现等号左右两侧的泛型继承关系，这在scala中分别称之为泛型的协变和逆变。
  *  在scala中的大部分集合的泛型，都是具有协变和逆变特性的，比如Option,List
  *
  */
object _03GenericOps {
    def main(args: Array[String]): Unit = {
        val myList:MyList[Person] = new MyList[Person]();
        //scala是非常灵活的，不仅仅只能做到等号左右两侧类型一致，同时还可以做到等号左右两侧有继承关系
        val myList1:MyList[Person] = new MyList[Student]();

        val myList2:MyList1[Student] = new MyList1[Person]();
    }
}
class Person
class Student extends Person
class Worker extends Person
class MyList[+T] {//scala中把这种结构称之为泛型的协变
}

class MyList1[-T] {//scala中把这种结构称之为泛型的逆变

}