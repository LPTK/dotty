class StatefulExtr[A] {
  var state: A = _
  def unapply(a:A): Some[A] = { state = a; Some(a) }
}
