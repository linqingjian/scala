package scala.p6.implicits

/*
    隐式转换参数
        也就是说一个函数的参数被implicit关键字修饰，把这些参数称之为隐式转换操作
      首先，该参数，不一定非得要进行（手动、显式）传递（赋值），因为有时候有默认值
      其次，该参数，会自动的在其作用域范围内进行检索，找到相适应的变量，来完成赋值
        但是该变量必须要被implicit关键字所修饰
 */
object _04ImplicitOps {
    def main(args: Array[String]): Unit = {
        val array = Array(3, -6, 7, 1, 0, 9, 4, 2)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))

//        array.sorted
        println("排序后的数组：" + array.sorted.mkString("[", ", ", "]"))
        //降序排序，默认的sorted是升序排序
        array.sorted(new Ordering[Int](){
            override def compare(x: Int, y: Int): Int = y.compareTo(x)
        }).foreach(num => print(num + "\t"))
        println
        //隐式地指定
        implicit val ord = new Ordering[Int](){
            override def compare(x: Int, y: Int): Int = y.compareTo(x)
        }//这里会自动将ord赋值给array.sorted中的参数
        println("排序后的数组：" + array.sorted.mkString("[", ", ", "]"))
        println("------------------------------------------")
        val list = List[(String, Int)](
            //name      age
            ("zhangsan", 13),
            ("zhangsan1", 13),
            ("zhangsan2", 14),
            ("zhangsan3", 15)
        )
        //现在要按照list中得age进行排序
        list.sortBy{case (name, age) => age}.foreach(println)
    }
}
