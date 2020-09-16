package scala.p4.function

/*
    scala中常见的高阶函数
    这些高阶函数，都是作用在集合上面
 */
object _02FunctionOps {
    def main(args: Array[String]): Unit = {
//        filterOps
//        mapOps
//        flatMapOps
//        reduceOps
//        dropWhileOps
//        sortWithOps
//        groupByOps
        partitionByOps
    }
    /*
        filter
        filter: (A => Boolean)
        该函数作用在集合的每一个元素A的身上，返回值为Boolean，filter意为过滤，要过滤掉集合中得某一部分数据。
        满足条件(返回值为false)的数据被过滤。此时满足条件与否就可以使用Boolean来标识。
        该函数返回值为true的元素，将会被保留；反之将会被过滤
     */
    def filterOps(): Unit = {
        val array = 1 to 10
        //过滤掉集合中得偶数，留下集合中得奇数
        var filtered = array.filter((num:Int) => num % 2 != 0)
        println(filtered.mkString("[", ", ", "]"))
        filtered = array.filter((num) => num % 2 != 0)
        println(filtered.mkString("[", ", ", "]"))
        filtered = array.filter(num => num % 2 != 0)
        println(filtered.mkString("[", ", ", "]"))
        filtered = array.filter(_ % 2 != 0)
        println(filtered.mkString("[", ", ", "]"))
    }
    /*
    map (p: A => B)
        一个集合中的所有元素A，都要作用在该匿名函数之上，每一个元素，调用一次该匿名函数，
        将元素A，最后转化为元素B。
        需要注意的是，A和B的数据类型，可以一致，也可以不一致。
        map操作，其实是一个one-2-one的映射操作。
     */
    def mapOps: Unit = {
        val array = 1 to 10
        //将集合中得每一个元素，扩大原来的1.5倍
        var newArray = array.map((num:Int) => num * 1.5)
        println(newArray.mkString("[", ", ", "]"))
        newArray = array.map((num) => num * 2.5)
        println(newArray.mkString("[", ", ", "]"))
        newArray = array.map(num => num * 3.5)
        println(newArray.mkString("[", ", ", "]"))
        newArray = array.map(_* 4.5)
        println(newArray.mkString("[", ", ", "]"))
    }

    /*
        flatMap-->(f:A => Iterable[B])
        flatMap和map操作，比较相似，不同之处在于作用于匿名函数之后的返回值类型不一样。
        map操作，是one-2-one的操作
        flatMap操作，是一个one-2-many的操作
    */
    def flatMapOps(): Unit = {
        val array = Array(
            "zhao ren  jie",
            "li ji",
            "yang yi"
            )
        //提取这个数组中得每一个单词
        var wordsArray = array.flatMap((line:String) => {
            val words:Array[String] = line.split("\\s+")
            words
        })

        wordsArray.foreach(word => println(word))
        println("----------------------------------------------------")
        wordsArray = array.flatMap((line) => {
            val words:Array[String] = line.split("\\s+")
            words
        })

        wordsArray.foreach(word => println(word))
        println("----------------------------------------------------")
        wordsArray = array.flatMap(line => {
            val words:Array[String] = line.split("\\s+")
            words
        })

        wordsArray.foreach(word => println(word))
        println("----------------------------------------------------")
        wordsArray = array.flatMap(_.split("\\s+"))

        wordsArray.foreach(word => println(word))
    }
    /*
        reduce => (p: (A, A) => A)
        reduce是一个聚合函数，将2个A，转化为1个A（reduce函数作用在集合中得元素，进行聚合，得到新的值）
        这里面的三个A，分别代表的是什么意思？
        通过下面的案例，我们知道了这个3个A，
        第一次，前两个A，就是从集合中提取前两个元素进行聚合操作，将聚合结果就是第三个A；
        同时赋值给下一次调用该函数的第一个A，同时从集合中再提取一个元素赋值给第二个A，进行第二次的聚合操作，将聚合结果赋值给
        了第三个A。
        。。。。
        直接集合中得元素完毕
     */
    def reduceOps(): Unit = {
        val array = 1 to 6
        var sum = 0
        for(i <- array) {
            sum += i
        }
        println("sum=" + sum)
        println("----------------使用reduce函数来模拟sum----------------")
        sum = array.reduce((v1:Int, v2:Int) => {
            println(s"v1: $v1, v2: $v2")
            v1 + v2
        })
        println("sum=" + sum)
        println("----------------使用reduce函数来模拟sum----------------")
        sum = array.reduce((v1, v2) => v1 + v2)
        println("sum=" + sum)
        println("----------------使用reduce函数来模拟sum----------------")
        //匿名函数参数有多个的话，（）不可以被省略
        sum = array.reduce(_+_)
        println("sum=" + sum)
    }
    /*
        dropWhile (p:A => Boolean)
        匿名函数和filter的一样，作用在集合的每一个元素，返回值为Boolean类型，
        dropWhile删除满足boolean条件的元素，直到不满足条件为止
     */
    def dropWhileOps: Unit = {
        val array = Array(3, -6, 7, 1, 0, 9, 4, 2)
        //循环删除其中的偶数
        var newArray = array.dropWhile((num:Int) => num % 2 == 0)
        println(newArray.mkString("[", ", ", "]"))

    }
    /*
        sortWith  --->排序
        sortWith ((A, A) => Boolean)
            既然返回值是一个Boolean类型，同时，sortWith就是排序的操作，显然就是要对这两个A比较出大小，自然就是boolean类型
     */
    def sortWithOps: Unit = {
        val array = Array(3, -6, 7, 1, 0, 9, 4, 2)
        var newArray = array.sortWith((v1:Int, v2:Int) => v1 > v2)
        println(newArray.mkString("[", ", ", "]"))
        newArray = array.sortWith((v1, v2) => v1 < v2)
        println(newArray.mkString("[", ", ", "]"))
        newArray = array.sortWith(_ < _)
        println(newArray.mkString("[", ", ", "]"))
    }
    /*
        groupBy --->分组，其实就是sql中的 group by
        因为要进行分组，所以被分组的集合的数据类型，必须是k-v键值对，或者必须要构建出按照某一个值来进行分组

     */
    def groupByOps: Unit = {
        val array = Array(
            "甘肃,兰州",
            "甘肃,岷县",
            "甘肃,张掖",
            "北京,朝阳",
            "北京,昌平",
            "湖北,武汉",
            "湖北,黄石",
            "湖北,荆州"
        )
        //按照省份，对每一个城市进行分组
        val province2Cities = array.groupBy((line:String) => line.substring(0, line.indexOf(",")))
        for((province, cities) <- province2Cities) {
            println(province + "-->" + cities.mkString("[", ", ", "]"))
        }
        //grouped(size)，将原集合以size大小分成若干个小的集合列表
        println("------------------------------")
        val arraies = array.grouped(3)
        for(arr <- arraies) {
            println(arr.mkString("[", ", ", "]"))
        }

    }
    /*
        partition (p:A => Boolean): (集合A， 集合B)
        作用在原先的集合的每一个元素之上，满足条件的元素，进入集合A，不满足条件的元素进入集合B，最后完成原集合分区的效果。
       */
    def partitionByOps: Unit = {
        val array = Array(3, -6, 7, 1, 0, 9, 4, 2)
        //将集合array，按照4分区，小于4的在一个分区中，大于等于4的在一个分区中
        val (left, right) = array.partition((num:Int) => num < 4)

        println(left.mkString("[", ", ", "]"))
        println(right.mkString("[", ", ", "]"))
    }
}
