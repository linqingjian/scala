package scala.p6.generic

/**
  * 泛型类
  *     就是在类上面，定义一个泛型，在类上面定义的这个泛型，
  *     你可以把它当做成员，在类的作用域范围内进行使用
  */
object _01GenericClassOps {
    def main(args: Array[String]): Unit = {

    }
}

//网数据库注册一个用户
case class User()
class UserController {
    val us = new UserServiceImpl[User]()
    def regist(user: User) {
        us.save(user)
    }
}

trait UserService[T] {
    def save(t:T)
}

class UserServiceImpl[User] extends UserService[User] {
    val userDao = new UserDaoImpl[User]()
    def save(user:User): Unit = {
        userDao.insert(user)
    }
}

trait UserDao[T] {
    def insert(t:T)
}
class UserDaoImpl[T] extends UserDao[T] {
    def insert(t:T): Unit = {

    }
}