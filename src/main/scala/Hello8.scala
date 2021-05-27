import Ch8Ex1.BankAccount
import Ch8Ex5.Point

import scala.collection.mutable.ArrayBuffer

object Hello8 extends App {
  print("Решение упражнений 8 главы")
}

// Задача №1
object Ch8Ex1 extends App {
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance

    def currentBalance: Double = balance

    def deposit(amount: Double): Double = {
      balance += amount
      balance
    }

    def withdraw(amount: Double): Double = {
      balance -= amount
      balance
    }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    private var balance = initialBalance

    override def deposit(amount: Double): Double = {
      balance += (amount - 1)
      balance
    }

    override def withdraw(amount: Double): Double = {
      balance -= (amount + 1)
      balance
    }
  }
}

// Задача №2
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var operationCounter = 0
  private var balance = initialBalance

  override def deposit(amount: Double): Double = {
    if (operationCounter < 3) {
      balance += amount
      operationCounter += 1
      balance
    }
    else {
      balance += (amount - 1)
      balance
    }
  }

  override def withdraw(amount: Double): Double = {
    if (operationCounter < 3) {
      balance -= amount
      operationCounter += 1
      balance
    }
    else {
      balance -= (amount + 1)
      balance
    }
  }

  def earnMonthlyInterest(percent: Double): Double = {
    operationCounter = 0
    balance = balance * percent
    balance
  }
}

// Задача №3
abstract class Animal(var name: String) {
    def info: Unit
    def voice: Unit
}

class Fish(name: String) extends Animal(name) {

   def info: Unit = println(s"Это рыба по имени $name")

   def voice: Unit = println(s"$name молчит")
}

class Cat(name: String) extends Animal(name) {
   def info: Unit = println(s"Это кошка по имени $name")

   def voice: Unit = println(s"$name мяукает")
}

// Задача №4
object Ch8Ex4 extends App {

  abstract class Item() {
    def price: Int

    def description: String
  }

  class SimpleItem(pr: Int, desc: String) extends Item {
    val price: Int = pr
    val description: String = desc
  }

  class Bundle extends Item {
    val items = new ArrayBuffer[SimpleItem]

    def addSimpleItem(item: SimpleItem): ArrayBuffer[SimpleItem] = {
      items += item
      items
    }

    override def price: Int = {
      var price = 0
      for (item <- items) {
        price += item.price
      }
      price
    }

    override def description: String = {
      val descBuffer = new ArrayBuffer[String]()
      val desc: String = {
        for (item <- items) {
          descBuffer += item.description
        }
        descBuffer.mkString(", ")
      }
      desc
    }
  }

  val phone = new SimpleItem(500, "phone")
  val desktop = new SimpleItem(5000, "PC")
  val notebook = new SimpleItem(2000, "notebook")

  val bundle = new Bundle
  bundle.addSimpleItem(phone)
  bundle.addSimpleItem(desktop)
  bundle.addSimpleItem(notebook)

  println(bundle.price)
  println(bundle.description)

}

// Задача №5
object Ch8Ex5 extends App {
  class Point(val x: Double, val y: Double)

  class LabeledPoint(val name: String, x: Double, y: Double) extends Point(x, y)

  val point = new LabeledPoint("Black Thursday", 1929, 230.07)
  println(point.name, point.x, point.y)
}

//  Задача №6
object Ch8Ex6 extends App {
  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(val leftTop: Point, val rightTop: Point, val leftLow: Point, val rightLow: Point) extends Shape {
    val centerPoint: Point = new Point((leftTop.x + rightLow.x) / 2, (leftTop.y + rightLow.y) / 2)
  }

  class Circle(val diameter1: Point, val diameter2: Point) extends Shape {
    val centerPoint: Point = new Point((diameter1.x+diameter2.x)/2, (diameter1.y+diameter2.y)/2)
  }
}

// Задача №7
object Ch8Ex7 extends App {
  class Square extends java.awt.Rectangle {
    var angle = new Point(0, 0)
    var width = 0

    def this(angle: Point) {
      this()
      this.angle = angle
    }

    def this(angle: Point, width: Int) {
      this(angle: Point)
      this.width = width
    }
  }
}