object Main {
  def main(args: Array[String]): Unit = {
    (1: Any) match {
      case x: String | Int => "OK"
      case (_: String) | (_: Int) => "OK"
      case (s: String) | _: Int => s   // error: Illegal variable in pattern alternative
    }
  }
}

// #1612
object Test {
  def g(p:(Int,Int)) = p match {
    case (10,n) | (n,10) => println(n) // error // error (Illegal variable in pattern alternative)
    case _ => println("nope")
  }
}
