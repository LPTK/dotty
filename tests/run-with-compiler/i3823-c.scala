import scala.quoted._
object Test {
  def main(args: Array[String]): Unit = {
    def f[T](x: Expr[T])(implicit t: Type[T]) = '{
      val z = $x
    }
    implicit val toolbox: scala.quoted.Toolbox = scala.quoted.Toolbox.make(getClass.getClassLoader)
    println(f('{2})(Type.IntTag).show)
  }
}

