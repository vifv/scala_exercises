import scala.beans.BeanProperty

object Hello5 extends App {
  print("Решение упражнений 5 главы")
}

// Задача №1
object Ch5Ex1 extends App {
  class Counter {
    private var value: Long = 0
    def increment() { value += 1}
  }
}

// Задача №2
object Ch5Ex2 extends App {
  class BankAccount {
    private var balanceAcc = 0

    def withdraw(i: Int): Unit = {
      println(s"Вы сняли $i деняк")
      balanceAcc = balanceAcc - i
    }

    def deposit(i: Int): Unit = {
      println(s"Хей чемпион, ты положил на баланс $i!")
      balanceAcc = balanceAcc + i
    }

    def balance: Int = {
      println(s"У тебя целых $balanceAcc денех!!!")
      balanceAcc
    }
  }

  var myAccount = new BankAccount
  myAccount.deposit(300000)
  myAccount.withdraw(250)
  myAccount.balance
}

// Задача №3
object Ch5Ex3 extends App {
  class Time (hrs: Int, min: Int) {
    if (hrs > 23 && hrs < 0)
      throw new IllegalArgumentException("Введите валидное время")
    if (min > 59 && min < 0)
      throw new IllegalArgumentException("Введите валидное время")
    private val hours = hrs
    private val minutes = min

    def before(other: Time): Boolean = {
      if (hours < other.hours) true
      else if (hours == other.hours && minutes < other.minutes) true
      else false
    }
  }

  val firstTime = new Time(23, 12)
  val secondTime = new Time(1, 56)
  print(secondTime.before(firstTime))
}

// Задача №4
object Ch5Ex4 extends App {
  class Time (hrs: Int, min: Int) {
    if (hrs > 23 && hrs < 0)
      throw new IllegalArgumentException("Введите валидное время")
    if (min > 59 && min < 0)
      throw new IllegalArgumentException("Введите валидное время")
    private val minutes = min+(hrs*60)

    def before(other: Time): Boolean = {
      if (minutes < other.minutes) true else false
    }
  }

  val firstTime = new Time(23, 12)
  val secondTime = new Time(1, 56)
  print(secondTime.before(firstTime))
}

// Задача №5
object Ch5Ex5 extends App {
  class Student {
    @BeanProperty var name: String = "unknown"
    @BeanProperty var id: Long = 18
  }
}

// Задача №7
object Ch5Ex7 extends App {
  class Student(s: String) {
    val nameArr: Array[String] = s.split(" ")
    if (nameArr.length != 2) throw new IllegalArgumentException("Неправильный ввод.")
    val firstName: String = nameArr(0)
    val secondName: String = nameArr(1)
  }
  val ivan = new Student("Ivan Ivanov")
  println(ivan.firstName)
  print(ivan.secondName)
}

// Задача №8
object Ch5Ex8 extends App {
  class Car(var company: String,var model: String) {
    var year = -1
    var id: String = " "

    def this(company: String, model: String, year: Int)
    {
      this(company, model)
      this.year = year
    }

    def this(company: String, model: String, id: String) {
      this(company, model)
      this.id = id
    }

    def this(company: String, model: String, year: Int, id: String) {
      this(company, model)
      this.id = id
      this.year = year
    }
  }
  val priora = new Car("Lada", "Priora")
  val granta = new Car("Lada", "Granta", 2015)
  val solaris = new Car("Hyundai", "Solaris", "A111AA")
  val rio = new Car("Kia", "Rio", 2018, "A112AA")
  println(priora.year, granta.id, solaris.model, rio.company)
}