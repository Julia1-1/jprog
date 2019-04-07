object Main6 {
  def countChars(str: String): Int = {
    str.groupBy(identity).map(para => para._1).size
  }
  val str = "Scala"
  println(countChars(str))
}
