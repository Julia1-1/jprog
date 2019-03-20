import scala.annotation.tailrec

object Main4 {
  def compress[A](seq: Seq[A]): Seq[(A, Int)] = {
    @tailrec
    def rekurencja(seq: Seq[A], seq1: Seq[A], nowa: Seq[(A, Int)], licznik: Int): Seq[(A, Int)] = {
      if(seq.isEmpty) nowa :+ (seq1.last, licznik)
      else {
        if(seq1.last == seq.head) {
          rekurencja(seq.tail, seq1 :+ seq.head, nowa, licznik+1)
        } else {
          rekurencja(seq.tail, seq1 :+ seq.head, nowa :+ (seq1.last, licznik), 1)
        }
      }
    }
    rekurencja(seq.tail, Seq(seq.head), Seq.empty, 1)

  }


  val seq = Seq('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
  val seq2 = Seq(2,2,2,2,5,5,1,0,2,9,9)
  println(compress(seq))
  println(compress(seq2))

}
