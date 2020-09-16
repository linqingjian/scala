package scala.p5.mode

//option操作
object _04ModeMatchOps {
    def main(args: Array[String]): Unit = {
        val map = Map[String, String](
            "China" -> "BJ",
            "India" -> "XDL",
            "Japan" -> "Tokyo"
        )
        val capitalOption:Option[String] = map.get("India")

        capitalOption match {
            case Some(capital) => println("India" +
                "'s capital is " + capital)
            case None => println("所查国家不存在")
        }
    }

}
