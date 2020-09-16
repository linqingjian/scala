package scala.p6.str

object _01StrOps {
    def main(args: Array[String]): Unit = {
        //假如在这里完成数据的读写操作
        if(args == null || args.length != 4) {
            println(
                """ Usage: <driver> <url> <user> <password>
                  | driver    : 数据库驱动
                  | url       : 数据库连接地址
                  | user      : 数据库名称
                  | password  : 数据库密码
                """.stripMargin)
            System.exit(-1)//异常退出
        }

        val Array(driver, url, user, password) = args

        println(s"driver: $driver")
        printf("url: %s\n", url)
        printf("user: %s\n", user)
        println("password: " + password)

    }
}
