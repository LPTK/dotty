class StatefulExtr[A] {
  var state: A = _
  def unapply(a:A): Some[A] = { state = a; Some(a) }
}
object Main {
  // def get[A,B]:Either[A,B]=>A|B = { case Left(a) | Right(a) => a }
  def get[A,B](e:Either[A,B]):A|B = e match { case Left(a) | Right(a) => a }
  def main(args: Array[String]): Unit = println(get(Left(11))->get(Right(22)))
}
