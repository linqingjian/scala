package homework

/**
 * 作业2：函数运用
 */
object HW2 {

  /**
   * 有字符数据如下
   * "qf1,98,true;qf2,100,true,qf2,99,true,qf2,96,true,qf2,97,true"
   * 请将其转换为元祖存储数据，形式如(String,Int,Boolean) 并用集合类型List保存这些数据并按照年龄排序
   */
  def funApply():Unit = {
    //数据
    val data = "qf1,98,true;qf2,100,true;qf2,99,true;qf2,96,true;qf2,97,true"

    //1 切割记录 -> 字符串 -> 数据集合类型
    val datas:Array[String] = data.split(";").toArray

    //2 切割数据列 -> 集合中的数据元素变形为元祖(map) -> 集合排序(sortWith)
    //*** 重点在2次函数应用
    val orderDatas :Array[(String,Int,Boolean)] = datas.map((s:String) =>{
      val sinfo = s.split(",")
      val List(names:String, ages:String, genders:String) = sinfo.toList
      val name:String = names
      val age:Int = ages.toInt
      val gender:Boolean = genders.toBoolean
      (name, age, gender)
    })
      .sortWith(
        (d1:(String,Int,Boolean), d2:(String,Int,Boolean)) => {
          d1._2 > d2._2
        }
      )

    //3 展示结果
    for(orderData:(String,Int,Boolean) <- orderDatas){
      println(s"orderData=${orderData}")
    }

  }


  def main(args: Array[String]): Unit = {
    funApply()
  }

}
