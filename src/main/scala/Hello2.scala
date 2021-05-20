object Hello2 extends App {
  print("Здесь решение задач из 2 главы")
}

// Задача №1
object Ch2Ex1 extends App {
  def signum(i: Int): Int = {
    if (i>0) 1
    else if (i<0) -1
    else 0
  }
  print(signum(5) + " " + signum(0)+ " " + signum(-6))
}

// Задача №2
// Возвращает (), тип Unit

// Задача №4
object Ch2Ex4 extends App {
  for ( i <- 10 to 0 by -1) println(i)
}

// Задача №5
object Ch2Ex5 extends App {
  def countdown(n: Int): Unit = for (i <- n to 0 by -1) println(i)
  countdown(5)
}

// Задача №6
object Ch2Ex6 extends App {
  def productx(s: String) = {
    val arr = for (i <- 0 until s.length) yield s(i).toInt
    arr.product
  }
  print(productx("Hello"))
  }

// Задача №7
object Ch2Ex7 extends App {
  val s = "Hello"
  print(s.map(_.toInt).product)
}

// Задача №8
object Ch2Ex8 extends App {
  def product(s: String): Int = s.map(_.toInt).product
  print(product("Hello"))
}

// Задача №10
import scala.math.pow
object Ch2Ex10 extends App {
  def func(x: Int, n: Int): Double = {
    if (n == 0) 1
    else if (n < 0) 1/func(x, -n)
    else if (n % 2 == 0) pow(func(x, n/2), 2)
    else x*func(x,n-1)
  }
  println(func(5,2))
  println(func(5,0))
  println(func(5,3))
  println(func(5,-1))
}