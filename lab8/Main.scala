object Main {
  def sum(seq: Seq[Option[Double]]): Double = {
    seq.filter(_.isDefined).map(_.get).sum // isDefined, czyli rozne od None
  }

  val seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sum(seq))
}
/*def sum(seq: Seq[Option[Double]]): Double = {
  seq.foldLeft(0.0) {
    (x,y) => y match {
      case None => x + 0.0
      case _ => x + y.get
    }
  }
}*/

/*
(a,b) => b match {
    case Some(a1) => a1 + a
    case None => a
} */
