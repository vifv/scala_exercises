import java.util.Scanner
import scala.collection.mutable

object Hello4 extends App {
  print("Решение упражнений 4 главы")
}

// Задача №1
object Ch4Ex1 extends App {
  val shop = mutable.Map("PC" -> 1000, "Phone" -> 500, "Juice" -> 10)
  val betterShop = shop.view.mapValues(price => price*0.9)
  for((k ,v) <- betterShop) println(k ,v)
}

// Задача №2
object Ch4Ex2 extends App {
  val mapa = mutable.Map[String, Int]("qwertyasdfgh" -> 1)
  val in = new Scanner(new java.io.File("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt"))
    while (in.hasNext()) {
      val str = in.next().replace("." , "").replace(",", "")
        .replace("-", "").replace("?", "")
        .replace("!", "").split(" ") //Здесь я очищаю текст от пунктуационных знаков и разделяю на массив слов
      for (s <- str) { // Здесь по моей задумке цикл должен проходить по каждому слову в своем массиве и сравнивать с картой,
                       // если слово совпадает с ключом - то закидываем в мапу этот же ключ со значением+1
                       // если нет, то добавляем ключ со значением 1
        for ((k, v) <- mapa)
          if (s.equals(k))
            mapa +=(k -> (v+1))
          else
            mapa +=(s -> 1)
      }
    }
  mapa -=("qwertyasdfgh")
  for ((k,v) <- mapa) println (k,v)
}


// Задача №6
object Ch4Ex6 extends App {
  val calend = mutable.LinkedHashMap[String, Int](
    "Понедельник" -> java.util.Calendar.MONDAY,
    "Вторник" -> java.util.Calendar.TUESDAY,
    "Среда" -> java.util.Calendar.WEDNESDAY,
    "Четверг" -> java.util.Calendar.THURSDAY,
    "Пятница" -> java.util.Calendar.FRIDAY,
    "Суббота" -> java.util.Calendar.SATURDAY,
    "Воскресенье" -> java.util.Calendar.SUNDAY
  )
  for ((k,v) <- calend) println(k,v)
}