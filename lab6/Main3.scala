import scala.annotation.tailrec

object Main3 {
  @tailrec
  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = {
    (seq) match {
      case (a1 +: an) => compute(an)(op(a1,init))(op)
      case Seq() => init
    }
  }

  val seq = Seq(1,2,3,4)
  val seq2 = Seq("ala"," ", "ma"," ", "kota")
  val op = (x: Int, y: Int) => (x + y)
  val op2 = (x: String, y: String) => x ++ y

  println(compute(seq)(0)(_ + _))
  println(compute(seq)(1)(_ * _))
  println(compute(seq2)("")(_ + _))

}
