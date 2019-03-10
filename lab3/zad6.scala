import scala.annotation.tailrec

object zad6 {
  def silnia(n: Int): Int = {
    @tailrec
    def rekurencja(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else rekurencja(n - 1, n * acc)
    }
    rekurencja(n, 1)
  }

  def trojkat(n: Int): Unit ={
    @tailrec
    def rekurencja2(n: Int, dlugosc: Int, pom1: Int, pom2: Int): Unit = {
      if(n == pom1) { 1
      } else if (n > pom1) {
          if (dlugosc >= pom1) {
            print(" ")
            rekurencja2(n, dlugosc-1, pom1, pom2)
          } else {
            if (pom1 >= pom2) {
              print(silnia(pom1)/(silnia(pom2)*silnia(pom1-pom2))+" ")
              rekurencja2(n, dlugosc, pom1, pom2+1)
            } else {
              print("\n")
              rekurencja2(n, n, pom1 + 1, 0)
            }
          }
      }
    }
    rekurencja2(n, n,0, 0)
  }
  print("Podaj wysokosc trojkąta: ")
  println(trojkat(io.StdIn.readInt()))

}
