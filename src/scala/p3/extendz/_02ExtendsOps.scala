package scala.p3.extendz

/*
    scala中也有类似于java中得类型检查和转换操作，
    不同之处在于scala中得不管是类型检查还是转换，都是对象的一个方法。
    isInstanceOf    --->类型检查
    asInstanceOf    --->类型转换
 */
object _02ExtendsOps {
    def main(args: Array[String]): Unit = {
        val w1 = new Worker("崔浩", 22)
        val w2 = new Worker("崔浩", 22)
        println(w1.equals(w2))
    }
}

class Worker {
    var name:String = _
    var age:Int = _
    def this(name:String, age:Int) {
        this
        this.name = name
        this.age = age
    }

    //第一种传统的方式
    /*
    override def equals(obj: scala.Any): Boolean = {
        if(!obj.isInstanceOf[Worker]) {//类型检查
            false
        } else {
            //obj是Worker
            val that = obj.asInstanceOf[Worker]//类型转换
            this.name.equals(that.name) && this.age == that.age
        }
    }
    */
    /*
        scala中，模式匹配的时候，如果没有匹配成功，会报错：scala.MatchError
        所以大家在编写模式匹配的时候，一定要把默认的情况加上
     */
    override def equals(obj: scala.Any): Boolean = {
       obj match {//scala的模式匹配 --》其实就是java中得switch case 或者多分支if else
           case that:Person => {
               this.name.equals(that.name) && this.age == that.age
           }
           case _ => {
               println("--默认的选项--")
               false
           }//case _就是java中switch case中得default选项
       }
    }
}
