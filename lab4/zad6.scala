import scala.annotation.tailrec

object zad6 {
  def merge[A](a: Seq[A], b: Seq[A])(leq: (A, A) => Boolean): Seq[A] = {
    @tailrec
    def rekurencja(newSeq: Seq[A], a: Seq[A], b: Seq[A]): Seq[A] = {
     if (a.isEmpty)
        newSeq ++ b
     else if (b.isEmpty)
        newSeq ++ a
     else {
       if (leq(a.head, b.head))
         rekurencja(newSeq :+ a.head, a.tail, b)
       else
         rekurencja(newSeq :+ b.head, a, b.tail)
     }
    }
    rekurencja(Seq.empty, a,b)
  }

  val a = Seq(1,3,5,8)
  val b = Seq(2,4,6,8,10,12)
  val warunek = (m: Int,n: Int) => m < n
  println(a)
  println(b)
  println(merge(a,b)(warunek))
}
