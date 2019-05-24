import scala.io.Source

object zad3 {
  def histogram(max: Int): Unit = {
    val plik: Seq[String] = Source.fromFile("src/main/ogniem_i_mieczem.txt").getLines().toList
    println(plik.flatMap(_.toLowerCase).partition(_.isLetter)._1.groupBy(identity).map(para =>
      if(para._2.size > max) (para._1, "*" * max)
      else (para._1, "*" * para._2.size)).foreach(println))
  }
  histogram(100)
}
