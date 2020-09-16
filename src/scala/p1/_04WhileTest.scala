package scala.p1

import scala.io.StdIn

/*
    登录用户名密码的游戏：三次机会，从控制台输入用户名密码，
    如果成功登录，返回登录成功，
    失败，则反馈错误信息！
    从控制台输入
        java中：Scanner/System.in
        scala:
            readInt(过时)
            readLine(过时)
            StdIn.readInt()
            StdIn.readLine
 */
object _04WhileTest {
    def main(args: Array[String]): Unit = {
        val dbUser = "root"
        val dbPwd = "sorry"
        var count = 3
        while(count > 0) {
            val user:String = StdIn.readLine("请输入您的用户名：")
            val password:String = StdIn.readLine("请输入您的密码：")
            if(dbUser == user && dbPwd == password) {//验证成功
//                println("恭喜您!" + user + ", 登录成功Xxx商城~")
//                println(s"恭喜您，${user}！登录成功Xxx商城~")
                printf("恭喜您，%s！登录成功Xxx商城~\n", user)
                count = -1
            } else {//验证失败
                count -= 1
//                println("用户名或者密码有误，您还有" + count + "次机会重试~")
//                println(s"用户名或者密码有误，您还有${count}次机会重试~")
                printf("用户名或者密码有误，您还有%d次机会重试~\n", count)
            }
        }
    }
}
