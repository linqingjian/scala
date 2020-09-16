package scala.p2.collection

import scala.collection.mutable

//scala集合之可变map
object _05MutableMapOps {
    def main(args: Array[String]): Unit = {
        //使用mutable.Map的伴生对象创建对象
        val personMap = mutable.Map[String, Int](
            "田梦杰" -> 22
        )

        //添加元素 即是修改又是添加，如果key存在就是修改，不存在就是添加
        personMap("王羽") = 29
        println(personMap)
        personMap.put("梁鹏飞", 23)
        personMap.put("李德胜", 38)
        println(personMap)

        //删除 java value = map.delete(key)
        val option:Option[Int] = personMap.remove("李德胜2")
        println("被删除元素对应的value：" + option.getOrElse(null))
        println("删除元素之后的集合：" + personMap)

        //map容器的大小
        val size = personMap.size
        println("size: " + size)
        //map容器的遍历
        val ks = personMap.keySet
        for(k <- ks) {
            val value = personMap(k)
            println(k + "--->" + value)
        }
        println("-------scala提供的遍历方式---------")
        for(kv <- personMap) {//这种方式就类似java中的entrySet kv就是java中得entry --》tuple
            val key = kv._1
            val value = kv._2
            println(key + "<--->" + value)
        }
        println("-------scala提供的遍历方式---------")
        for((k, v) <- personMap) {
            println(k + "--->" + v)
        }
        println("-------使用foreach操作遍历---------")
        personMap.foreach(kv => println(kv._1 + "<--->" + kv._2))
    }
}
