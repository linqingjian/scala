package scala.p2.collection

//scala中map的操作
object _04MapOps {
    def main(args: Array[String]): Unit = {
        //定义一个不可变map
        val personMap = Map[String, Int](
            "刘泽渝" -> 18,//k -> v
            "王羽" -> 19,
            ("杨懿" -> 20)
        )
        /*
            获取对应的值，通过key来获取 get方式获取的value是一个Option选项
            获取option中得之，通过option.get来实现
            Option选项有两种可能（两个子类）：
                Some：有值 可以通过get来获取其中的值
                None：没值 不能操作 java.util.NoSuchElementException: None.get
         */
        val key = "王羽2"
        if(personMap.contains(key)) {
            val ageOption: Option[Int] = personMap.get(key)
            println(ageOption)
            println("王羽的年龄is: " + ageOption.get)
        } else {
            println(key + "不会存在")
        }
        //map的获取方式二
        val age:Int = personMap("刘泽渝")//java.util.NoSuchElementException: key not found
        println("刘泽渝对应的年龄是： " + age)

        //上述两种获取的方式都不用，太麻烦了，使用下面的操作搞定
        //getOrElse(key, defaultValue)，存在返回对应的值，不存在，返回默认值defaultValue
        val finalAge = personMap.getOrElse(key, 13)
        println(key + "对应的年龄is： " + finalAge)

        //不可变map是不可以修改元素的值
//        personMap("王羽") = 29
        println(personMap)
        //删除
        val newMap = personMap.drop(1)//删除集合中得n元素，并返回新的集合，原集合不便
        println("原map： " + personMap)
        println("newMap： " + newMap)
    }
}
