import scala.annotation.tailrec

object Main1 {
  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
    @tailrec
    def rekurencja(seq: Seq[A]): Boolean = {
      if(seq.length==1) {
        true
      } else {
        if (leq(seq.head,(seq.tail).head)) {
          rekurencja(seq.tail)
        } else {
          false
        }
      }
    }
    rekurencja(seq)
  }
  val seq = Seq(1,2,3,4)
  val seq2 = Seq(1,8,2,1)
  type leq[A] = (A,A) => Boolean
  var leq: leq[Int] = (m: Int, n:Int) => m < n
  println(isOrdered(seq)(leq))
  println(isOrdered(seq2)(leq))
}
