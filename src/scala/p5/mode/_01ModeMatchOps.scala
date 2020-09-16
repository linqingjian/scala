package scala.p5.mode

import scala.io.StdIn

//scala模式匹配操作
object _01ModeMatchOps {
    def main(args: Array[String]): Unit = {
//        switchOps
//        yeildOps
//        caseOps
//        typeOps
        collectionOps
        //接受主函数参数的时候，就可以用到模式匹配
        /*
        val first = args(0)
        val second = args(1)
        val third = args(2)
        val fourth = args(3)
        */
        println("val second = args(1)")
        println("----------不用上述的这种赋值方式-------------")
        //这种方式，一定要主要参数的个数和Array中元素的个数保持一致
        val Array(first, second, third, fourth) = args
        println("first: " + first)
        println("second: " + second)
        println("third: " + third)
        println("fourth: " + fourth)

    }

    def collectionOps: Unit = {
        val array = Array(0, 1, 2)

        array match {
            //匹配当前数组，只有两个元素，如果匹配成功，将元素依次赋值给x和y
            case Array(x, y) => println(s"x=${x}, y=${y}")
            //匹配当前数组以0开头
            case Array(0, _ *) => println("该数组的首元素是0")
            case _ => println("other~")
        }
    }

    def typeOps: Unit = {
        class Person(name:String, age:Int) {
        }
        class Worker(name:String, age:Int) extends Person(name, age) {
            def work(): Unit = {
                println(s"工人同志${name}, 年龄为${age}正在热火朝天的休息~")
            }
        }

        class Student(name:String, age:Int) extends Person(name, age) {
            def study(): Unit = {
                println(s"学生${name}, 年龄为${age}正在紧锣密鼓的玩游戏~")
            }
        }

        def doSth(person:Person): Unit = {
            //类型检查 | 类型转换
            person match {
                case worker:Worker => worker.work()
                case stu:Student =>  stu.study()
                case _ => println("没有匹配的类型，请重新传入")
            }
        }
        doSth(new Student("杨懿", 15))


    }

    def caseOps: Unit = {
        "Hello World".foreach(c => println(
            c match {
                case ' ' => ','
                case _ => c
            }
        ))
    }

    def yeildOps: Unit = {
        println("请输入一个字符：")
        val ch:Char = StdIn.readChar()

       val sign = ch match {
            case '-' =>  1
            case '+' =>  -1
            case '*' =>  2
            case '/' =>  -2
            case _ =>  0
        }
        println("sign: " + sign)
    }

    /*
        switch(ch) {
            case '+':

                break;
            case '-':
                break;
            default:
                break;
        }
     */
    def switchOps: Unit = {
        var sign = 0
        println("请输入一个字符：")
        val ch:Char = StdIn.readChar()

        ch match {
            case '-' => sign = 1
            case '+' => sign = -1
            case '*' => sign = 2
            case '/' => sign = -2
            case _ => sign = 0
        }
        println("sign: " + sign)
    }
}
