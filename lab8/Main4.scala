object Main4 {
  def swap[A](seq: Seq[A]): Seq[A] = {
    seq.zipWithIndex.foldLeft[Seq[A]](Seq()) ((a,b) =>
    if(b._2 % 2 == 0) a :+ b._1
    else a match {
      case pocz :+ ost => (pocz :+ b._1) :+ ost
      case _ => a :+ b._1
    }
    )
  }
  val seq = Seq(1,2,3,4,5)
  println(swap(seq))
}
