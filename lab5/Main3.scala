import scala.annotation.tailrec

object Main3 {
  def deStutter[A](seq: Seq[A]): Seq[A] = {
    @tailrec
    def rekurencja(seq: Seq[A], nowa: Seq[A]): Seq[A] = {
      if(seq.isEmpty) nowa
      else {
        if (seq.head == nowa.last) {
          rekurencja(seq.tail, nowa)
        } else {
          rekurencja(seq.tail, nowa :+ seq.head)
        }
      }
    }
    rekurencja(seq.tail, Seq(seq.head))
  }

  val seq = Seq(1,1,2,4,4,4,1,3)
  val seq2 = Seq(1,2,3,4,5,9,9,5,5,6,7,9,1,1,11,11)
  println(deStutter(seq))
  println(deStutter(seq2))
}
