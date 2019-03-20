import scala.annotation.tailrec

object Main2 {
  def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean): Seq[A] = {
    @tailrec
    def rekurencja(seq: Seq[A], nowa: Seq[A]): Seq[A] = {
      if(seq.isEmpty) {
        nowa
      } else {
        if(leq(a,seq.head)) {
          (nowa :+ a) ++ seq
        } else {
          rekurencja(seq.tail, nowa :+ seq.head)
        }
      }
    }
    rekurencja(seq, Seq.empty)
  }
  val seq = Seq(1,2,5,8,9,10)
  val seq2 = Seq(1,1,3,4,7,13)
  val a = 5
  val b = 12
  type leq[A] = (A,A) => Boolean
  var leq: leq[Int] = (m: Int, n:Int) => m < n
  println(insertInto(a,seq)(leq))
  println(insertInto(b,seq2)(leq))
}
