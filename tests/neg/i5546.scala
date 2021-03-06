import language.strictEquality

object O {

  opaque type Meters = Double
  object Meters {
    def apply(d: Double): Meters = d
    val m: Meters = 1.0
    assert(m == 1.0)   // OK
  }
  implicit def eqM: Eq[Meters, Meters] = Eq

  opaque type Feet = Double
  object Feet { def apply(d: Double): Feet = d }
  implicit def eqF: Eq[Feet, Feet] = Eq

  def main(args: Array[String]): Unit = {
    println(Feet(3) == Meters(3)) // error: cannot compare
    println(Feet(3) == 3.0) // error: cannot compare
  }
}
