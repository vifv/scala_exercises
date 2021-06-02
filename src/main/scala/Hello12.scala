import scala.collection._
object Hello12 extends App {
  print("Решение упражений 12 главы")
}

// Задача №1
object Ch12Ex1 extends App {
  def values(fun: Int => Int, low: Int, high: Int): IndexedSeq[(Int, Int)] = {
    for(i <- low to high) yield (i,fun(i))
  }

  print(values(x => x*x, -5, 5))
}

//Задача №2
object Ch12Ex2 extends App {
  def largestElem(array: Array[Int]): Int = array.reduceLeft((a, b) =>  if (a>b) a else b)

  val arr = Array(1,2,3,4,5,6,7,8,9,10)
  print(largestElem(arr))
}

// Задача №3
object Ch12Ex3 extends App {
  def factorial(i: Int): Int = if (i>0) (1 to i).product else 1

  print(factorial(3))
}

// Задача №4
object Ch12Ex4 extends App {
  def factorial(i: Int): Int = (1 to i).foldLeft(1)(_*_)
  print(factorial(3))
}

// Задача №5
object Ch12Ex5 extends App {
  def largest(fun: Int => Int, inputs: Seq[Int]): Int =
    inputs.map(fun(_)).reduceLeft((a, b) =>  if (a>b) a else b)
  print(largest(x => 10*x-x*x, 1 to 10))
}

// Задача №7
object Ch12Ex7 extends App {
  def adjustToPair(fun: (Int, Int) => Int)(tuple: (Int, Int)): Int =  fun(tuple._1, tuple._2)

  val pairs = (1 to 10) zip (11 to 20)
  println(pairs.map(adjustToPair(_+_)(_)))
}

// Задача №8
object Ch12Ex8 extends App {
  val a: IndexedSeq[String] = IndexedSeq("Wake", "up", "Neo")
  val b: IndexedSeq[Int] = IndexedSeq(4, 3, 3)
  println(a.corresponds(b)(_.length == _))
}