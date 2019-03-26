import scala.annotation.tailrec

object Main2 {
  def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) = {
    @tailrec
    def rekurencja(seq: Seq[A], seqP: Seq[A], seqNP: Seq[A], licznik: Int): (Seq[A], Seq[A]) = {
      (seq) match {
        case(a1 +: an) => {
          if(licznik%2==0)    rekurencja(an, seqP :+ a1, seqNP, licznik+1)
          else    rekurencja(an, seqP, seqNP :+ a1, licznik+1)
        }
        case Seq() => (seqP, seqNP)
      }

    }
    rekurencja(seq, Seq.empty, Seq.empty, 0)
  }

  val seq = Seq(1,3,5,6,7)
  println(divide(seq))
}
