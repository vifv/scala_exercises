
import scala.io.{BufferedSource, Source}


object Hello9 extends App {
  println("Решение упражнений 9 главы")
}

// Задача №1
object Ch9Ex1 extends App {
  val source = Source.fromFile("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt")
  val stringsArray = source.mkString.split("\n")
  source.close
  val reverseStringsArray = stringsArray.reverse
  for (elem <- reverseStringsArray) println(elem)
}

// Задача №3
object Ch9Ex3 extends App {
  val source = Source.fromFile("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt")
  def searchLongWords(source: BufferedSource): Unit = {
    for( i <- source.mkString
      .replaceAll( "\\p{Punct}", " ")
      .replaceAll("\n", " ")
      .split(" ")) if (i.length > 11) println(i)
  }
  searchLongWords(source)
}

// Задача №4
object Ch9Ex4 extends App {
  def calculate(source: BufferedSource): (Int, Int, Int, Int) = {
    val stringBuffer = source.mkString.split(" ")
    val numsBuffer = stringBuffer.map(_.toInt)
    val sortedBuf = numsBuffer.sortWith(_ < _)
    val min = sortedBuf(0)
    val max = sortedBuf.reverse(0)
    val mid = (numsBuffer.sum) / numsBuffer.length
    val sum = numsBuffer.sum
    Tuple4(sum, mid, max, min)
  }

  val source = Source.fromFile("/Users/vladislav/scala/scala_exercises/src/main/resources/nums.txt")
  source.close
  print(calculate(source))
}

// Задача №5
object Ch9Ex5 extends App {
  for (i <- 0 to 20) println("%8.0f\t%f".format(math.pow(2, i), math.pow(2, -i)))
}


// Задача №7
object Ch9Ex7 extends App {
  def filterReader(source: BufferedSource) : Unit = {
    val stringBuffer = source.mkString
      .replaceAll("[0-9]", "")
      .replaceAll("\\p{Punct}", " ")
      .split("\\s+")
    for (i <- stringBuffer) println(i)
  }

  filterReader(Source.fromFile("/Users/vladislav/scala/scala_exercises/src/main/resources/check.txt"))
}