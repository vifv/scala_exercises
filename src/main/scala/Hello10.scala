object Hello10 extends App {
  print("Решение упражнений 10 главы")
}

// Задача №1
trait RectangleLike {

  def getX: Double

  def getY: Double

  def getWidth: Double

  def getHeight: Double

  def setFrame(x: Double, y: Double, w: Double, h: Double): Unit

  def grow(h: Double, v: Double): Unit = {
    var x0 = getX
    var y0 = getY
    var x1 = getWidth
    var y1 = getHeight
    x1 += x0
    y1 += y0

    x0 -= h
    y0 -= v
    x1 += h
    y1 += v

    if (x1 < x0) {
      x1 -= x0
      if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE
      if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE
      else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE
    }
    else {
      if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE
      else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE
      x1 -= x0
      if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE
      else if (x1 > Integer.MAX_VALUE) x1 = Integer.MAX_VALUE
    }

    if (y1 < y0) {
      y1 -= y0
      if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE
      if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE
      else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE
    }
    else {
      if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE
      else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE
      y1 -= y0
      if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE
      else if (y1 > Integer.MAX_VALUE) y1 = Integer.MAX_VALUE
    }

    setFrame(x0.toInt, y0.toInt, x1.toInt, y1.toInt)
  }


  def translate(dx: Int, dy: Int): Unit = {
    var x = getX
    var y = getY
    var width = getWidth
    var height = getHeight

    var oldv = x
    var newv = oldv + dx
    if (dx < 0) {
      if (newv > oldv) {
        if (width >= 0) {
          width += newv - Integer.MIN_VALUE
        }
        newv = Integer.MIN_VALUE
      }
    }
    else {
      if (newv < oldv) {
        if (width >= 0) {
          width += newv - Integer.MAX_VALUE
          if (width < 0) width = Integer.MAX_VALUE
        }
        newv = Integer.MAX_VALUE
      }
    }
    x = newv
    oldv = y
    newv = oldv + dy
    if (dy < 0) {
      if (newv > oldv) {
        if (height >= 0) {
          height += newv - Integer.MIN_VALUE
        }
        newv = Integer.MIN_VALUE
      }
    }
    else {
      if (newv < oldv) {
        if (height >= 0) {
          height += newv - Integer.MAX_VALUE
          if (height < 0) height = Integer.MAX_VALUE
        }
        newv = Integer.MAX_VALUE
      }
    }
    y = newv
  }
}

object Ch10Ex1 extends App {
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)
}

// Задача №2
class OrderedPoint extends java.awt.Point with scala.math.Ordered[Point] {
  override def compare(point: Point): Int = {
    if (x < point.x || (x == point.x && y < point.y)) 1
    else if (x == point.x && y == point.y) 0
    else -1
  }
}

// Задача № 4

trait CryptoLogger {
  def encrypt(msg: String, i: Int = 3): String = {
    val encryptedMsg = msg.map(_ + i).map(_.toChar).mkString
    encryptedMsg
  }

  def decrypt(msg: String, i: Int = 3): String = {
    val decryptedMsg = msg.map(_ - i).map(_.toChar).mkString
    decryptedMsg
  }
}

object Ch10Ex4 extends App with CryptoLogger {
  val hello = "Hello World"
  val secret = encrypt(hello)
  val notASecretAnymore = decrypt(secret)
  println(hello, secret, notASecretAnymore)
}

// Задача №8
object Ch10Ex8 extends App {


  trait Animal {
    def born: Unit

    def move: Unit
  }

  trait Fish extends Animal {
    def born: Unit = {
      println("Метаем икру")
    }

    def move: Unit = {
      println("Плаваем")
    }
  }

  trait Amphibian extends Animal with Fish {
    override def born: Unit = {
      super.born
    }

    override def move: Unit = {
      println("Плаваем и Прыгаем")
    }
  }

  class Riba extends Fish {}

  class Zhaba extends Amphibian {}

  val fish = new Riba
  fish.born
  fish.move

  val frog = new Zhaba
  frog.born
  frog.move
}
