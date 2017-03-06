enum Tree[T] {
  case True { type T = Boolean }
  case False { type T = Boolean }
  case Zero { type T = Int }
  case Succ(n: Tree[Int]) { type T = Int }
  case Pred(n: Tree[Int]) { type T = Int }
  case IsZero(n: Tree[Int]) { type T = Boolean }
  case If[T](cond: Tree[Boolean], thenp: Tree[T], elsep: Tree[T])
}

object Test {
  import Tree._

  def eval[T](e: Tree[T]): T = e match {
    case True => true
    case False => false
    case Zero => 0
    case Succ(f) => eval(f) + 1
    case Pred(f) => eval(f) - 1
    case IsZero(f) => eval(f) == 0
    case If(cond, thenp, elsep) => if (eval(cond)) eval(thenp) else eval(elsep)
  }

  val data = If(IsZero(Pred(Succ(Zero))), Succ(Succ(Zero)), Pred(Pred(Zero)))

  def main(args: Array[String]) = {
    println(s"$data --> ${eval(data)}")
  }
}
