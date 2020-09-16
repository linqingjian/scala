package scala.p4.function

/*
    OFP
 */
object _01FunctionOps {
    def main(args: Array[String]): Unit = {
//        functionOps1
//        functionOps2
        functionOps3
//        functionOps4
    }

    //高阶函数的类型推断
    def functionOps4(): Unit = {
        def sayBye(name:String, func: (String) => Unit) = {
            func(name)
        }

        sayBye("臧振宇", (name:String) => println(name))
        //简化 根据类型推断，可以省略匿名函数的参数类型
        sayBye("王霞", (name) => println(name))
        //简化，如果匿名函数，只有一个参数的时候，可以将()胜利
        sayBye("田梦杰", name => println(name))
        //简化，到这一步，就可以使用通配符，来代表匿名函数的参数，此时的name，可以使用_代替
        //sayBye("李青沛", _ => println(_))//编译不通过
        sayBye("李青沛", println(_))
        //最终的版本，是可以将通配符"_"也可以省略掉的
        sayBye("杨懿", println)
        println("-----------------------------------------")
        val array = Array(1, 2, 3, 4, 5, 6)
        array.foreach((num:Int) => println(num))
        println("~~~~~~~~~~~~~~")
        array.foreach((num) => println(num))
        println("~~~~~~~~~~~~~~")
        array.foreach(num => println(num))
        println("~~~~~~~~~~~~~~")
        array.foreach(println(_))
        println("~~~~~~~~~~~~~~")
        array.foreach(println)
    }
    /**
      * 高阶函数：带函数参数的函数，函数的参数是函数，把这种函数称之为高阶函数(high level function)
      *
      */
    def functionOps3(): Unit = {

        //定义了一个高阶函数
        def sayBye(name:String, func: (String) => Unit) = {
            func(name)
        }

        sayBye("臧振宇", (name:String) => println(name))
        sayBye("韦超", (name:String) => func(name))
        sayBye("韦超", (name) => func(name))
        sayBye("韦超", name => func(name))
        sayBye("韦超", func(_))
        sayBye("韦超", func)
    }

    def func(str:String):Unit = {
        println("一日之计在于晨")
        println(str)
        println("一年之计在于春")
    }
    /*
        匿名函数：没有名字的函数
        完整的scala函数：
            def funcName(params):returnType = {body}
        匿名函数：
            (params)=> {body}
     */
    def functionOps2(): Unit = {
        val sayBye = (name:String) => println(name)

        def sayByeBye = (name:String) => println("good bye, " + name)

        sayBye("吴企旺")
        sayByeBye("王青宇")
    }

    /*
        函数可以作为值，传递给另外一个函数或者变量
        语法特点，必须要在函数后面加上空格和下划线
     */
    def functionOps1: Unit = {
        def sayGoodBye(name:String): Unit = {
            println("good bye to " + name)
        }
        //函数作为值传递给另外一个变量
        val sayBye = sayGoodBye _
        //函数作为值传递给另外一个函数定义
        def sayByeBye = sayGoodBye _

        //函数的调用
        sayBye("王羽")
        sayByeBye("刘泽渝")
    }


}
