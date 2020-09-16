package scala.p5.mode

object _02ModeMatchOps {
    def main(args: Array[String]): Unit = {
        caseOps
    }

    def caseOps: Unit = {
        abstract class Expr //抽象类 表达式
        case class Var(name:String) extends Expr
        case class UnOp(expr:Expr, operator:String) extends Expr
        case class Number(num:Double) extends Expr
        case class BinOp(val left:Expr, operator:String, right:Expr) extends Expr

        def test(expr:Expr) = {
            expr match {
                case Var(name) => println("Var: " + name)
                case Number(num) => println("Number: " + num)
                case UnOp(Var(name), "+") => println(name + "+")
                case BinOp(Number(num1), "+", Number(num2)) => println(num1 + num2)
                case BinOp(Number(num1), "-", Number(num2)) => println(num1 - num2)
                case BinOp(Number(num1), "*", Number(num2)) => println(num1 * num2)
                case _ => println(expr)
            }
        }
        val binOp = BinOp(Number(3.0), "-", Number(5.2))
        binOp.left//getter
        test(binOp)
    }
}
