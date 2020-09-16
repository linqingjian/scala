package scala.p5.collection

//list的api操作
object _02ListOps {
    def main(args: Array[String]): Unit = {
        val list = Nil //构建了一个空的list列表
        val left = List(1, 2, 3, 4)
        val right = List(4, 5, 6, 7, 8)
        //crud操作
        //增
        /*
           增加一个元素：
            list.+:(A):将元素A添加到集合list的首部，生成一个新的集合，原集合不变
            list.::(A):将元素A添加到集合list的首部，生成一个新的集合，原集合不变
            list.:+(A):将元素A添加到集合list的尾部，生成一个新的集合，原集合不变
           添加一个集合：
            list.++(A):将集合A添加到集合list的尾部，生成一个新的集合，原集合不变
            list.:::(A):将集合A添加到集合list的首部，生成一个新的集合，原集合不变
            list.++:(A):将集合A添加到集合list的首部，生成一个新的集合，原集合不变
         */
        var newList = left.+:(5)
        println("left.+:(5): " + newList)
        newList = left.::(5)
        println("left.::(5): " + newList)
        newList = left.:+(5)
        println("left.:+(5): " + newList)
        //添加集合
        newList = left.++(right)
        println("left.++(right): " + newList)
        newList = left.:::(right)
        println("left.:::(right): " + newList)
        newList = left.++:(right)
        println("left.++:(right): " + newList)
        //查 list(index)
        val ret = newList(3)
        println("newList(3): " + ret)
        //改
//        newList(3) = -7//value update is not a member of List
//        println("newList(3): " + newList(3))
        //删
        newList = newList.drop(3)
        println("newList.drop(3): " + newList)//7, 8, 1, 2, 3, 4)
        //判断
        println("newList.contains(5): " + newList.contains(5))
        //遍历
        newList.foreach(println)
        //其它的操作
        println("------------------------------")
        val listUnion = left.union(right)//相当于sql中得union all
        println("left.union(right): " + left.union(right))
        val listIntersect = left.intersect(right)//两个集合的交集
        println("left.intersect(right): " + listIntersect)
        val listDiff = left.diff(right)//差集操作
        println("left.listDiff(right): " + listDiff)
        val take2 = left.take(2)//获取集合中得前N个元素，如果这个几个是有序的，那得到就是TopN
        println("left.take(2): " + take2)
    }
}
