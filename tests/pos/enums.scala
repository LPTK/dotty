enum List[+T] {
  case Cons[T](x: T, xs: List[T])
  case Nil
  case Snoc[U](xs: List[U], x: U)
}
