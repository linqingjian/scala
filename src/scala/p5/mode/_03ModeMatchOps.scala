package scala.p5.mode

/*  主要是通过case class模拟枚举
    在java中，定义枚举，可以通过关键字enum来完成，但是在scala中没有这样的结构
    scala中说白了没有枚举，只能通过一个工具类来表示Enumeration
    更加常用的一种做法就是使用样例类来模拟枚举

   扩展：
    如果说一类的所有的子类，在运行期都是已知的，
    我们就可以讲这个类使用关键字sealed声明为密封的，被sealed声明的类，称之为密封类
 */
object _03ModeMatchOps {
    def main(args: Array[String]): Unit = {

        accrosRoad(TrafficLight.YELLOW)
        println("--------使用case class来模拟枚举--------------")
        accrosRoad(RED("霓虹灯"))

    }
    def accrosRoad(light: Light): Unit = {
        light match {
            case RED(name) => println(name + "等警示：行车不规范，亲人类两行")
            case YELLOW(name) => println(name + "等警示：快人5秒钟，可能快人1辈子")
            case GREEN(name) => println(name + "等警示：开开心心开出去，平平安安开回来")
        }
    }

    def accrosRoad(light: TrafficLight.Value): Unit = {
        light match {
            case TrafficLight.RED => println("行车不规范，亲人类两行")
            case TrafficLight.YELLOW => println("快人5秒钟，可能快人1辈子")
            case TrafficLight.GREEN => println("开开心心开出去，平平安安开回来")
        }
    }


    //定义scala中得一个枚举 scala中得枚举类型是，Xxx.Value
    object TrafficLight extends Enumeration {
        val RED, YELLOW, GREEN = Value
    }
}

//密封类
sealed class Light(name:String)

case class RED(name:String) extends Light(name)
case class YELLOW(name:String) extends Light(name)
case class GREEN(name:String) extends Light(name)