object Main3 {
  def indices[A](seq: Seq[A], el: A): Set[Int] = {
    seq.zipWithIndex.filter({ case (element, _)  => element==el}).map(para => para._2).toSet
  }

  val seq = Seq(1,2,1,1,5)
  val el= 1
  val el2 = 7

  println(indices(seq,el))
  println(indices(seq,el2))

}
