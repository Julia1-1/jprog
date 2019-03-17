import scala.annotation.tailrec
object zad5 {
  type Pred[A] = A => Boolean
  @tailrec
  def forall[A](a: Seq[A])(pred: A => Boolean): Boolean = {
      if(a.isEmpty) true
      else if (pred(a.head)) forall(a.tail)(pred)
      else false
    }

    val a = Seq(1,3,5,7)
    val np= (n : Int) => n % 2 !=0
    if(forall(a)(np)) println("TRUE")
    else println("FALSE")
}
