object set {
  def main(args: Array[String]) {
  val site = Set("1000phone", "Google", "Baidu")
  val nums: Set[Int] = Set()
  println( "第一网站是 : " + site.head )
  println( "最后一个网站是 : " + site.tail )
  println( "查看列表 site 是否为空 : " + site.isEmpty )
  println( "查看 nums 是否为空 : " + nums.isEmpty )
  }
}
