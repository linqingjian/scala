object aa {


  def main(args: Array[String]): Unit = {
    val num1=5
    val num2=3
    val num3=1
    for(i<-1 to num1;j<-1 to num2;k<-1 to num3 if (i == j && j == k)){
    println(s"i=$i, j=$j, k=$k")

  }
}
}