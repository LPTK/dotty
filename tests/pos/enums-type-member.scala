enum E[T] { case A { type S = Int; type T = String } }
object Main {
  E.A : E[String]
}
