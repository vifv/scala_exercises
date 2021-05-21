import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting



object Hello3 extends App {
  print("Решение упражнений 3 главы")
}

// Задача №1
object Ch3Ex1 extends App {
  def massiv(n: Int) : mutable.Buffer[Int] = {
    val res = new ArrayBuffer[Int]()
    for (i <- 0 until n) res.insert(i, i)
    res
  }
  val b = massiv(10)
  for(elem <- b) println(elem)
}

// Задача №2
object Ch3Ex2 extends App {
  def change(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) if (i % 2 != 0) {
      val ch = arr(i)
      arr(i) = arr(i - 1)
      arr(i - 1) = ch
    }
  }
  val arr = Array(1,2,3,4,5,6,7)
  change(arr)
  for(i <- arr) println(i)
}

// Задача №3
// Я абсолютно понимаю что это решение совершенно не такое каким его подразумевали авторы,
// но не смог придумать ничего лучше этого, чтобы хотя бы формально условия задачи были выполнены.
object Ch3Ex3 extends App {
  def changeNew(arr: Array[Int]): Array[Int] = {
    for (i <- 1 until arr.length)
      if (i % 2 != 0) {
      val ch = arr(i)
      arr(i) = arr(i-1)
      arr(i-1) = ch
    }
    val arrCopy = for (i <- arr) yield i
    arrCopy
  }
  val arr0 = Array(1,2,3,4,5,7,7,8,9)
  val arr1 = changeNew(arr0)
  for (i <- arr1) println(i)
}

// Задача №4

object Ch3Ex4 extends App {
  def sortirovka(arr: Array[Int]) : Array[Int] = {
    val result = new Array[Int](arr.length)
    var counter = 0
    for (i <- arr) if (i>0) {
      result(counter) = i
      counter +=1
    }
    for (i <- arr) if (i<=0) {
      result(counter) = i
      counter +=1
    }
    result
  }
  val arr0 = Array(1,2,0,4,-5,7,-7,8,9)
  val arr1 = sortirovka(arr0)
  for (i <- arr1) println(i)
}

// Задача №5
object Ch3Ex5 extends App {
  def middle(arr: Array[Double]): Double = {
    val middle = arr.sum/arr.length
    middle
  }
  val array = Array(1.0, 2.7, 3.5, 7.6)
  print(middle(array))
}

//Задача №6
object Ch3Ex6 extends App {
  val arr0 = Array[Int](1,2,0,4,-5,7,-7,8,9)
  val arr1 = ArrayBuffer(1,2,0,4,-5,7,-7,8,9)
  Sorting.quickSort(arr0) // сортируем массив арр0
  val arr0Reversed = arr0.reverse // получаем развернутую версию отсортированного массива
  val arr1Sorted = arr1.sortWith(_>_) // с буфером удобнее - получаем то что нам надо в одну строчку
  for (elem <- arr0Reversed) print(elem)
  println(" ")
  for (elem <- arr1Sorted) print(elem)
}

// Задача №7
object Ch3Ex7 extends App {
  val arr = Array[Int](1,1,0,0,-5,-5,-7,-7,9)
  val arrRes = arr.distinct
  for (elem <- arrRes) print (elem)
}

// Задача №8
object Ch3Ex8 extends App {
  def negativeCleaner(arr: ArrayBuffer[Int]) :ArrayBuffer[Int] = {
    val negArr = for (i <- arr.indices if arr(i) < 0) yield i //создаем буфер с индексами отрицательных элементов
    val revArr = negArr.reverse //разворачиваем его
    for (elem <- 0 to revArr.length-2) arr.remove(revArr(elem))
    //с помощью revArr удаляем отрицательные элементы из оригинального буфера
    arr
  }
  val res = ArrayBuffer[Int](1,2,3,4,-1,-2,-3,-4,2,4)
  negativeCleaner(res)
  for (elem <- res) print(elem)
}

// Задача №10
// Просто написал то что было нужно в задании. Вернулось 3 формата граф изображений
import java.awt.datatransfer._

object Ch3Ex10 extends App {
  val flavors = SystemFlavorMap.getDefaultFlavorMap.
    asInstanceOf[SystemFlavorMap]
  val arrayBuffer = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  print(arrayBuffer)
}
