import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.language.postfixOps

object Hello13 extends App {
  print("Решение упражнений 13 главы")
}

// Задача №1
object Ch13Ex1 extends App {
  def symbolIndexes(string: String): mutable.Map[Char, mutable.Set[Int]] = {
    val map = mutable.Map[Char, mutable.Set[Int]]()
    for(i <- 0 until string.length) {
      map.getOrElseUpdate(string(i), new mutable.LinkedHashSet[Int]) +=i}
    map
    }
  val mapChar = symbolIndexes("mississipi")
  for(i <- mapChar) print(i)
  }

// Задача №3
object Ch13Ex3 extends App {
  def removeSecond(list: ListBuffer[_]): ListBuffer[_] = {
    for (i <- list.length-1 to 0 by -1 if i % 2 !=0) list.remove(i)
    list
  }

  val list = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  removeSecond(list)
  for (i <- list) print(i)

  def removeSecond2(list: ListBuffer[_]): IndexedSeq[Any] = {
    val removedList = for (i <- list.indices if i % 2 == 0) yield list(i)
    removedList
  }
  println("")
  val list2 = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val newList2 = removeSecond2(list2)
  for (i <- newList2) print(i)
}

// Задача №8
object Ch13Ex8 extends App {
  def doubling(array: Array[Double], rows: Int): Array[Array[Double]] = {
    val it = array grouped rows
    val arrayBuffer = new ArrayBuffer[Array[Double]]
    while (it.hasNext) arrayBuffer+=it.next()
    arrayBuffer.toArray
  }

  val array = Array(1.0, 2.2, 4.4, 3.2, 3.4, 2.2, 45.6)
  val deepArray = doubling(array, 2)
  for(i <- deepArray) println(i.mkString("Array(", ", ", ")"))
}


