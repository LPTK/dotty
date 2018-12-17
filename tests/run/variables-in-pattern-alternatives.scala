object Main {
  def get0[A, B](e: Either[A, B]): A | B = e match { case Left(a) | Right(a) => a }
  def get1[A,B](e:Either[A,Option[B]]): A | Some[B] = e match { case Left(a) | Right(a @ Some(_)) => a }
  def main(args: Array[String]): Unit = {
    assert(get0(Left(11)) == 11)
    assert(get0(Right(22)) == 22)
    assert(get1(Left(11)) == 11)
    assert(get1(Right(Some(22))) == None)
    assert(scala.util.Try(get1(Right(None))).isFailure)
  }
}
