object Main {
  def get[A, B](e: Either[A, B]): A | B = e match { case Left(a) | Right(a) => a }
  def main(args: Array[String]): Unit = {
    assert(get(Left(11)) == 11)
    assert(get(Right(22)) == 22)
  }
}
