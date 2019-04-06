object Main3 {
  def deStutter[A](seq: Seq[A]): Seq[A] = {
      seq.foldLeft[Seq[A]](Seq()) {
        (n,m) => (n,m) match {
          case (Seq(), _) => n :+ m
          case (a1 :+ an, _) => if(an != m) n :+ m
          else n
        }
      }
  }
  val seq = Seq(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(seq))
}
/*
if(n.isEmpty) n :+ m
else if(n.last == m) n
else n :+ m
*/