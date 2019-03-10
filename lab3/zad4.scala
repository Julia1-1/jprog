import scala.annotation.tailrec

object zad4 {
  def pierwsza(n: Int): Boolean = {
    @tailrec
    def rekurencja(n: Int, i: Int): Boolean = {
      if(i == n) {
        return true
      } else {
        if(n%i!=0) {
          rekurencja(n, i+1)
        } else {
          return false
        }
      }
    }
    rekurencja(n, 2)
  }
  println("Podaj liczbę: ")
  if(pierwsza(io.StdIn.readInt())) {
    println("Liczba jest liczbą pierwszą")
  } else {
    println("Liczba nie jest pierwsza")
  }


}
