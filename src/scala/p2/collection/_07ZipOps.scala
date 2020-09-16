package scala.p2.collection

//zip拉链操作
object _07ZipOps {
    def main(args: Array[String]): Unit = {
        val province = Array("甘肃", "山东", "河南", "广西", "湖北", "成都", "江苏")
        val capital = Array("兰州", "济南", "郑州", "南宁", "武汉")

        val pc = province.zip(capital)//如果两个集合长度不一致，会自动的做裁剪

        for(kv <- pc) {
            val p = kv._1
            val c = kv._2
            println(p + "--->" + c)
        }
        println("--------------zipAll---------------------")
        /*
            zipAll会使用后面的参数对没有匹配上的值自动做填充
            其中第一个元素，会和第二个集合中多余的元素进行配对
            第二个元素，会和第一个集合中多余的元素进行配对
         */
        val pcAll = province.zipAll(capital, "四川", "南京")
        for(kv <- pcAll) {
            val p = kv._1
            val c = kv._2
            println(p + "<--->" + c)
        }
    }
}
