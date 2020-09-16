package scala.p2.func

/**
  * scala的默认参数和带名参数
  */
object _03FunctionOps {
    def main(args: Array[String]): Unit = {
        showAddr("李青沛", 1686868668L, "山东")//对默认参数进行了覆盖
        showAddr("刘泽渝", 1595959559L)//使用了默认参数
        //scala在函数调用的时候，可以带上函数参数名称进行参数的传递
        showAddr(name = "小超超", 18888888888L)
        //因为可以带名参数的传递，所以scala参数可以不用严格按照参数列表顺序进行传递
        showAddr(phone=1383838438L, province = "甘肃", name="李老师")
    }

    /**
      * 在scala中如果给一个参数列表中得某一个参数在定义的时候赋值了，被称之为默认参数
      * 既然有了默认值，那么在调用函数的时候，就可以省略掉该参数的赋值
      * @param name
      * @param phone
      * @param province
      */
    def showAddr(name:String, phone:Long, province:String = "北京"): Unit = {
        println(s"name=${name}, phone=${phone}, province=${province}")
    }
}
