import scala.collection.mutable.ArrayBuffer
import scala.math.abs

object Hello11 extends App {
  print("Решение упражнений 11 главы")
}

// Задача №4
object Ch11Ex4 extends App {
  class Money(doll: Int, cent: Int) {
    var dollar = if (cent > 99) doll + cent / 100 else doll
    var cents = if (cent > 99) cent - cent / 100 * 100 else cent

    def +(money: Money): Money = new Money(dollar + money.dollar, cents + money.cents)

    def -(money: Money): Money = {
      if ((cents - money.cents) < 0) new Money(dollar - money.dollar - 1, cents - money.cents + 100)
      else new Money(dollar - money.dollar, cents - money.cents)
    }

    def ==(money: Money): Boolean = {
      if (dollar == money.dollar && cents == money.cents) true
      else false
    }

    def <(money: Money): Boolean = {
      if (dollar < money.dollar || (dollar == money.dollar && cents < money.cents)) true
      else false
    }
  }

  val money1 = new Money(25, 135)
  val money2 = new Money(7, 399)
  println(money1.dollar, money1.cents)
  println(money2.dollar, money2.cents)
  val money3 = money1 - money2
  val money4 = money1 + money2
  println(money1 == money2)
  println(money3.dollar, money3.cents)
  println(money4.dollar, money4.cents)
  println(money1 < money1)
}


// Задача №9
object Ch11Ex9 extends App {
  class RichFile(var filepath: String) {
    def unapply(file: RichFile): (String, String, String) = {
      val arrayPath = file.filepath.mkString
        .reverse
        .replaceFirst("/", " ")
        .replaceFirst("\\.", " ")
        .reverse
        .split(" ")
      Tuple3 (arrayPath(0), arrayPath(1), arrayPath(2))
    }
  }
  val path = new RichFile("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt")
  val pathNames = path.unapply(path)
  println(pathNames)
}

// Задача №10
object Ch11Ex10 extends App {
  class RichFile(var filepath: String) {


    def unapplySeq(file: RichFile): Seq[String] = {
      file.filepath.mkString
        .replaceAll("/"," ")
        .replaceFirst(" ", "")
        .split(" ").toSeq
    }
  }

  val path = new RichFile("/Users/vladislav/scala/scala_exercises/src/main/resources/myfile.txt")
  val pathNames = path.unapplySeq(path)
  for (i <- pathNames) println(i)
}