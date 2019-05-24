import scala.io.Source

object Main3 extends App {
  val plik: Seq[String] = Source.fromFile("liczby.txt").getLines().toList
  val przyklad = Seq(1,3,2,4,5,6)
  val result = plik.map(_.toInt).partition(n => n%2==0)
  println(result)
  println("Przyklad: " + przyklad.partition(n => n%2==0))
}