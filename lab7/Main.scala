object Main {
    def subseq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
      seq.drop(begIdx).take(endIdx-begIdx+1)
    }
    val seq = Seq(1,2,4,3,6,5)
    val begIdx = 2
    val endIdx = 4
    println(subseq(seq,begIdx,endIdx))
}
