import java.util.Scanner
import scala.collection.mutable
import scala.io.Source
import scala.util.Sorting

object Hello4 extends App {
  print("Решение упражнений 4 главы")
}

// Задача №1
object Ch4Ex1 extends App {
  val shop = mutable.Map("PC" -> 1000, "Phone" -> 500, "Juice" -> 10)
  val betterShop = shop.view.mapValues(price => price * 0.9)
  for ((k, v) <- betterShop) println(k, v)
}

// Задача №2
object Ch4Ex2 extends App {
  val source = Source.fromFile("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt")
  val wordsArray = source.mkString
    .replaceAll("\\p{Punct}", " ")
    .replaceAll("^", " ")
    .replaceAll("$", " ")
    .replaceAll("\\s+"," ")
    .split(" ")
  source.close()
  val lowCaseWordsArr = wordsArray.map(_.toLowerCase)
  val wordsMap = lowCaseWordsArr.groupBy(identity)
  var wordsMapRes = mutable.Map[String, Int]()
    for ((k,v) <- wordsMap) wordsMapRes +=(k -> v.length)
  for ((k,v) <- wordsMapRes) println(k,v)
}



// Задача №6
object Ch4Ex6 extends App {
  val calendar = mutable.LinkedHashMap[String, Int](
    "Понедельник" -> java.util.Calendar.MONDAY,
    "Вторник" -> java.util.Calendar.TUESDAY,
    "Среда" -> java.util.Calendar.WEDNESDAY,
    "Четверг" -> java.util.Calendar.THURSDAY,
    "Пятница" -> java.util.Calendar.FRIDAY,
    "Суббота" -> java.util.Calendar.SATURDAY,
    "Воскресенье" -> java.util.Calendar.SUNDAY
  )
  for ((k, v) <- calendar) println(k, v)
}

// Задача №8
object Ch4Ex8 extends App {
  def minmax(values: Array[Int]): (Int, Int) = {
    Sorting.quickSort(values)
    values(0) -> values.reverse(0)
  }
  val arr = Array(1,6,9,3,56,12,34,-2,0,22)
  print(minmax(arr))
}

// Задача №9
 object Ch4Ex9 extends App {
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    var countMin = 0
    var countMax = 0
    var countEq = 0
    for (f <- values) {
      if (f < v) countMin +=1
      else if (f > v) countMax +=1
      else countEq +=1
    }
    Tuple3(countMin, countEq, countMax)
  }
    val values = Array(1,2,3,4,5,6,7,8,9,10)
    print(lteqgt(values, 3))
}

// Задача №10
// Получаем Вектор кортежей
object Ch10Ex10 extends App {
  print("Hello".zip("World"))
}
