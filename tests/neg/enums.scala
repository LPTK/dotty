enum List[+T] {
  case Cons(x: T, xs: List[T]) // error: not found: type T // error // error
  case Nil
  case Snoc[U](xs: List[U], x: U)
}

enum class X {
  case Y // error: case not allowed here
}

enum E(val x: Int) {
  case A // error: missing argument for parameter x of constructor E: (x: Int)E
  case B(x: Int)
}

enum class E2(val x: Int)
object E2 {
  case A // error: missing argument for parameter x of constructor E2: (x: Int)E2
  case B(x: Int)
}
