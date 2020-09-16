package scala.homework

/**
  */
object HomeWorkTest1 {
	def main(args: Array[String]): Unit = {
		orderPrint(3, 9)
		orderPrint(-6, 9, 3)
		println("2000年是否为闰年：" + judgeLeapYear(2000))
		println("2001年是否为闰年：" + judgeLeapYear(2001))
		printNarcissisticNumber()
		printNum()
		println(printReverse(12320))
		printAAA(2)
	}

	/*
	求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字（1-9之间）计算的数据的个数是5。例如2+22+222+2222+22222
	 */
	def printAAA(num:Int): Unit = {
		var str = ""
		for(i <- 1 to 5) {
			var tmp = 0
			for(j <- 1 to i) {
				tmp = tmp * 10 + num
			}
			str = s"${str}+${tmp}"
		}
		println(str.substring(1))
	}
	/*
	给定一个n位的整数，将该数位逆置，例如给定12345变成54321，12320变成2321
	要求:输入是数字-->打印的结果也要是一个数字 12345 -> 54321    12320 --> 2321    12032 -->23021
	 */

	def printReverse(num:Int):Int = {
		var tmp1 = num
		var tmp2 = num
		var sum = 0
		while(tmp1 != 0) {
			tmp2 = (tmp1 % 10)
			tmp1 = tmp1 / 10
			sum = sum * 10 + tmp2
			println(s"处理之后：tmp1=${tmp1}, tmp2=${tmp2}")

		}
		sum
	}



	/*
		7.在屏幕上输出以下内容：
		12345
		1234
		123
		12
		1
	 */
	def printNum(): Unit = {
		for(i <- 0 until 5; j <- 1 to (5 - i)) {
			print(j)
			if(j == 5 - i) {
				println
			}
		}
	}
	/*
	输出1000以内所有的水仙花数，所谓水仙花数是指一个3位数，其各位数字立方和等于该数本身。
	 */
	def printNarcissisticNumber(): Unit = {

		for(i <- 100 until 1000) {
			val gw = i % 10
			val sw = i / 10 % 10
			val bw = i / 100 % 10
//			println(i+ "个位" + gw + ", 十位：" + sw + "，百位：" + bw)
			if(i == gw * gw * gw + sw * sw * sw + bw * bw * bw) {
				println(i + "是水仙花数~")
			}
		}
	}
	/*
		输入一个年份，判断是否是闰年
	    能被400整除
	    能被4整除，不能被100整除
	 */
	def judgeLeapYear(year:Int):Boolean = {
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			true
		} else {
			false
		}
	}
	//输入三个数(互不相同)，并将三个升序输出(升序(从小到大)
	def orderPrint(a:Int, b:Int, c:Int): Unit = {
		var first = a
		var second = b
		var third = c
		if(first > second) {
			first = first ^ second
			second = first ^ second
			first = first ^ second
		}
		if(second > third) {
			second = second ^ third
			third = second ^ third
			second = second ^ third

			if(first > second) {
				first = first ^ second
				second = first ^ second
				first = first ^ second
			}
		}
		//
		println(first + "\t" + second + "\t" + third)

	}

	//1:输入两个数，按从小到大排序后输出
	def orderPrint(a:Int, b:Int): Unit = {
		val max = if(a > b) a else b
		val min = if(a < b) a else b
		println(min)
		println(max)
	}
}
