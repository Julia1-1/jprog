object Main5 {
  def freq[A](seq: Seq[A]): Map[A, Int] = {
    seq.groupBy(x => x).map(para => (para._1,para._2.size))
  }

  val seq = Seq('a','b','a','c','c','a')
  print(freq(seq))

}
/*
seq.groupBy(x => x).map({case (n,m) => (n,m.size)}) LUB
seq.groupBy(identity).mapValues(_.size)
 */