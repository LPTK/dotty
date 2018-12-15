class StatefulExtr[A] {
  var state: A = _
  def unapply(a:A): Some[A] = { state = a; Some(a) }
}
object Main {
  def get[A,B](e:Either[A,Option[B]]): A | Some[B] = e match { case Left(a) | Right(a @ Some(_)) => a }
  def main(args: Array[String]): Unit = {
    // println(get(Left(11))) // FIXME: scala.MatchError: Left(11) (of class scala.util.Left)
    println(get(Right(Some(22))))
    println(get(Right(None))) // FIXME: returns None
  }
}
