object Main2 {
  def position[A](seq: Seq[A], el: A): Option[Int] = {
    seq.zipWithIndex.filter({ case (element, _)  => element==el}).map(para => para._2).headOption
  }

  val seq = Seq(2,1,1,5)
  val el = 1
  val el2 = 7

  println(position(seq,el))
  println(position(seq,el2))
}
