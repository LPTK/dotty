object Main {
  // def get[A,B]:Either[A,B]=>A|B = { case Left(a) => a }
  def get[A,B](e:Either[A,B]):A|B = e match { case Left(a) => a }
  def main(args: Array[String]): Unit = println(get(Left(0)))
}
