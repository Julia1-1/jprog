import scala.annotation.tailrec

object Main5 {
  def applyForAll2[A,B,C](seq1: Seq[A], seq2: Seq[B], f: (A, B) => C): Seq[C] = {
    @tailrec
    def rekurencja(seq1: Seq[A], seq2 : Seq[B], seqC: Seq[C]): Seq[C] = {
      (seq1) match {
        case (a1 +: an) =>
          if(seq2.isEmpty) seqC
          else rekurencja(an, seq2.tail, seqC :+ f(a1,seq2.head))
        case Seq() => seqC
      }
    }
    rekurencja(seq1, seq2, Seq.empty)
  }

  val seq1 = Seq(1,3,5,6,7)
  val seq2 = Seq(2,3,4)
  type f[A,B,C] = (A,B) => C
  var leq :f[Int,Int,Int] = (m: Int, n: Int) => m + n
  println(applyForAll2(seq1, seq2, leq))
}
