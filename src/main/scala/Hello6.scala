import scala.io.StdIn

object Hello6 extends App {
  print("Решение заданий главы 6")
}

// Задача №1
object Conversions extends App {
  def inchesToCentimeters(inch: Double): Double =
    inch * 2.54

  def gallonsToLitres(gallon: Double): Double =
    gallon * 3.785

  def milesToKilometers(mile: Double): Double =
    mile * 1.61
}

//Задача №2
abstract class UnitConversions {
  def conversation(i: Double): Double
}

object inchesToCentimeters extends UnitConversions {
  override def conversation(i: Double): Double = i * 2.54
}

object gallonsToLitres extends UnitConversions {
  override def conversation(i: Double): Double = i * 3.785
}

object milesToKilometres extends UnitConversions {
  override def conversation(i: Double): Double = i * 1.61
}

// Задача №3
object Origin extends java.awt.Point {
}

// Задача №4
object Ch6Ex4 extends App {

  class Point(val x: Int, val y: Int) {}

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }

  val point = Point(2, 3)
}

// Задача №5
object Ch6Ex5 extends App {
  val firstString = StdIn.readLine()
  val arrString = firstString.mkString.split(" ")
  for (elem <- arrString.length - 1 to 0 by -1) print(arrString(elem) + " ")
}

// Задача №6
object CardSuits extends Enumeration {
  val spades: CardSuits.Value = Value("♠")
  val clubs: CardSuits.Value = Value("♣")
  val diamonds: CardSuits.Value = Value("♦")
  val hearts: CardSuits.Value = Value("♥")

  print(spades.toString)
}

// Задача №7

import CardSuits._

def check(suit: CardSuits.Value): Unit = {
  if (suit == diamonds || suit == hearts) print("Red") else print("Black")
}

// Задача №8

object Cube extends Enumeration {
  val red: Cube.Value = Value(0xff0000)
  val yellow: Cube.Value = Value(0xffff00)
  val lime: Cube.Value = Value(0x00ff00)
  val black: Cube.Value = Value(0x000000)
  val white: Cube.Value = Value(0xffffff)
  val magenta: Cube.Value = Value(0xff00ff)
  val blue: Cube.Value = Value(0x0000ff)
  val aqua: Cube.Value = Value(0x00ffff)
}