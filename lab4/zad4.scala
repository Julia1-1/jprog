import scala.annotation.tailrec

object zad4 {
  type MSeq[A] = A => String
  def size[A](a: Seq[A]): Int = {
    a match {
      case _ if a.isEmpty => 0
      case  (x +: y)  => 1 + size(y)
    }
  }
  def size2[A](a: Seq[A]): Int = {
    @tailrec
    def rekurencja(a: Seq[A], i: Int): Int = {
      if(a.length == i) {
        i
      } else {
        rekurencja(a, i+1)
      }
    }
    rekurencja(a, 0)
  }

  val a = Seq(1,8,4,2,0)
  println(size2(a))


}
