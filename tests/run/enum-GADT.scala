enum Expr[T] {
  case Const[T](v: T)
  case App[A,T](f: Expr[A => T], a: Expr[A])
  case Add(n: Expr[Int], m: Expr[Int]) { type T = Int }
  case Abs[A,B](f: Expr[A] => Expr[B]) {
    type T = A => B
    override def toString = s"Abs(a => ${f(Const("a").asInstanceOf[Expr[A]])})"
  }
}

object Test {
  import Expr._

  def eval[T](e: Expr[T]): T = e match {
    case Const(v) => v
    case Add(n,m) => eval(n)+eval(m)
    case abs: Abs[a,b] => (a: a) => eval(abs.f(Const(a)))
    case app: App[a,T] => eval(app.f)(eval(app.a))
  }

  val data = App(Abs((x: Expr[Int]) => Add(x, Const(1))), Const(2))

  def main(args: Array[String]) = {
    println(s"$data --> ${eval(data)}")
  }
}
