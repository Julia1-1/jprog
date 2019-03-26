import scala.annotation.tailrec

object Main {
  def applyForAll[A,B](seq: Seq[A], f: A => B): Seq[B] = {
    @tailrec
    def rekurencja(seq: Seq[A], seqB: Seq[B]): Seq[B] = {
      (seq) match {
        case (a1 +: an) => rekurencja(an, seqB :+ f(a1))
        case Seq() => seqB
      }
    }
    rekurencja(seq, Seq.empty)
  }
  val seq = Seq(1,3,5)
  type f[A,B] = A => B
  var leq : f[Int,Int] = (m: Int) => m + 3
  println(applyForAll(seq, leq))

}
