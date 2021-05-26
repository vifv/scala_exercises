object Hello7 extends App {
  print("Решение упражнений 7 главы")
}

object Ch7Ex6 extends App {

  import scala.jdk.CollectionConverters.MapHasAsScala

  val javaMap = new java.util.HashMap[String, Int]()
  javaMap.put("1", 1)
  javaMap.put("2", 2)

  val scalaMap = javaMap.asScala
}




