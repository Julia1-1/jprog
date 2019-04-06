object Main2 {
  def pairPosNeg(seq: Seq[Double]): (Seq[Double], Seq[Double]) = {
    seq.filter(_!=0.0).partition(_>0.0)
  }
  val seq = Seq(1,-5,0.0,-3.1,2,4,3,-6,5)
  println(pairPosNeg(seq))

}
