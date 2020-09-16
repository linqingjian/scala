import java.util

import scala.util.control.Breaks._

object Test {

  //(1) 输入参数n，m请按照n到m的范围对应的数字做累加求和
  def test1(args: Array[String]):Unit = {
    //1 取到外部参数
    val (ns, ms) = (args(0), args(1))

    //2 进行参数类型转换
    var n = ns.toInt
    var m = ms.toInt
    var x = 0
    if(n > m){
      x = n
      n = m
      m = x
    }

    //3 在n-m之间便利累加
    var sum = 0
    for(k <- n to m){
      sum += k
    }

    println(s"this sum is ${sum}")
  }


  //(2) 输入参数x，请判断x的数据内容的类型并打印出来（x为普通类型即可）
  //这里最好是正则表达式
  def test2(args: Array[String]):Unit = {
    //1 取到外部参数
    val (xs) = (args(0))

    //2 进行参数类型转换
    var result = "this is a string"
    try{
      var x = xs.toInt
      result = "this is a int"
    }catch{
      case e:Exception => {
        result = "this occur exception"
        //日志记录
      }
    }

    println(result)
  }

  //(2) 输入参数x，请判断x的数据内容的类型并打印出来（x为普通类型即可）
  def test22(args: Array[String]):Unit = {
    //1 取到外部参数
    val (xs: Any) = (args(0))

    //2 进行参数类型转换
    val result = if(xs.getClass == classOf[Int]){
      "Int"
    } else if(xs.getClass == classOf[String]){
      "String"
    }else {
      "Other"
    }
    println(result)
  }


  //(2) 假设给定数组为,根据输入参数x（x用来做数组对应下标值）去取数组对应值，要求必须输出结果（暂时不以判断越界退出的方式处理）
  //	val arr = Array[Int](1,2,3,4,5)
  def test3(args: Array[String]):Unit = {
    val arr = Array[Int](1,2,3,4,5)
    val arrLength = arr.length

    //1 取到外部参数
    val nums = args(0)
    val num = nums.toInt
    val value :Option[Int] = if(num > arrLength-1 || num < 0){
      None
    }else{
      Some(arr(num))
    }

    println(value)
  }


  //(4) 假设给定数组 val arr = Array[Int](1,2,3,4,5,5,4,3,2,1)
  // 输入参数x(如5)，请输出第一个匹配的数组位置并打印
  def test4(args: Array[String]):Unit = {
    val arrs = Array[Int](1,2,3,4,5,5,4,3,2,1)

    //1 取到外部参数
    val nums = args(0)
    val num = nums.toInt

    var value:Int = -1
    breakable{
      var idx = 0
      for(element <- arrs){
        if(element == num){
          value = idx
          break
        }
        idx += 1
      }
    }
    println(s"arrs=${arrs.mkString(",")}")
    println(s"match value=${num},value.position=${value}")
  }


  //(5) 输入字符串x(如a,b,c)和间隔符号s(如,) 请将字符串进行反转打印，并打印单词数量
  def test5(args: Array[String]):Unit = {
    //1 取到外部参数
    val (str, sep) = (args(0), args(1))

    val strs = str.split(sep).reverse
    val strLength = strs.length
    println(s"strs=${strs.mkString(",")}, strLength=${strLength}")
  }

  def main(args: Array[String]): Unit = {

    //test1(args)

    //test22(args)

    test3(args)

    //test4(args)

    //test5(args)


  }

}
