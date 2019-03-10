import scala.annotation.tailrec

object zad1 {

  def odwroc(napis: String): String = {
    @tailrec
    def odwroc2(napis2: String, kolejna: String): String = {

      if(napis2.length < 2) napis2+kolejna
      else odwroc2(napis2.tail, napis2.head + kolejna)
    }
    odwroc2(napis, "")
  }
  print("Podaj napis: ")

  println(odwroc(io.StdIn.readLine()))
}
