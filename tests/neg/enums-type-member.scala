enum E[T] { case A { type S = Int; type T = String } }
object Main {
  E.A : E[Int] // error: found:    E[String](E'.A); required: E[Int]
}
