import scala.math.BigInt.int2bigInt
import scala.math.sqrt

object Hello extends App {
    println("Hello world")
}

// Задача №2
object Exercise2 extends App {
    val res: Double = sqrt(3)*sqrt(3)
    print(3-res) // Конечно можно записать и в виде print(3-sqrt(3)*sqrt(3)), но по мне так читабельнее
}

// Задача №4
object Exercise4 extends App {
    print("crazy"*3)
}

// Задача №5
// max из двух Int возвращает наибольшее. Относится к RichInt

// Задача №6
object Exercise6 extends App {
    val res: BigInt = 2.pow(1024)
    print(res)
}

// Задача №7
// import scala.math.BigInt.{probablePrime}
// import scala.util.Random

// Задача №9
object Exercise9 extends App {
    val s = "Hello World"
    println(s(0))
    println(s.takeRight(1))
}

// Задача №10
object Exercise10 extends App {
    val s = "Hello World"
    println(s.take(1)) // Возвращает указанное количество символов с начала строки
    println(s.takeRight(3)) // Как предыдущее, только с конца строки
    println(s.drop(2)) // Возвращает строку без () символов с начала
    println(s.dropRight(4)) // Как предыдущее, только с конца строки
}





