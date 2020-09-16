package scala.p1

import scala.io.StdIn
import scala.util.control.Breaks._
/*
    基于while循环案例，来学习scala中循环结束的条件操作
    breakable
 */
object _07LoopOverOps {
    def main(args: Array[String]): Unit = {
        val dbUser = "root"
        val dbPwd = "sorry"
        breakable {
            var count = 3
            while(count > 0) {
                val user:String = StdIn.readLine("请输入您的用户名：")
                val password:String = StdIn.readLine("请输入您的密码：")
                if(dbUser == user && dbPwd == password) {//验证成功
                    printf("恭喜您，%s！登录成功Xxx商城~\n", user)
//                    return
                    break
                } else {//验证失败
                    count -= 1
                    printf("用户名或者密码有误，您还有%d次机会重试~\n", count)
                }
            }
        }
    }
}
