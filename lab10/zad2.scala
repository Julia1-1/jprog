import scala.io.Source

object Main2 extends App {
    val plik: Seq[String] = Source.fromFile("osoby.txt").getLines.toList
    val odwzorowanie = plik.groupBy(_.size).mapValues(_.size).map(para => (para._1-1, para._2))
    val seq = Seq("Jan Kowalski","Andrzej Nowak","Anna Kowalek")
    val przyklad = seq.groupBy(_.size).mapValues(_.size).map(para => (para._1-1, para._2))
    println(odwzorowanie)
    println(przyklad)
}