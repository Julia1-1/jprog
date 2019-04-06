object Main4 {
  def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
    seq.zipWithIndex.filter({case(_,nrIndeksu) => nrIndeksu!=k-1}).map({case (element,_) => element})
  }
  val seq = Seq(1,4,2,7,5)
  val k = 3
  println(remElems(seq,k))

}
/*
LUB    seq.zipWithIndex.filter(para => para._2!=k-1).map(para => para._1)

 */
