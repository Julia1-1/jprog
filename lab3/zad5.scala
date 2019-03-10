import scala.annotation.tailrec

object zad5 {
  def ciag(n: Int): Int = {
    @tailrec
    def rekurencja(n: Int, x: Int, y: Int): Int = {
      if(n==0) return 1
      if(n==1) return y
      rekurencja(n-1, y, x+y)
    }
    rekurencja(n, 1, 1)
  }
  println("Podaj liczbe: ")
  println(ciag(io.StdIn.readInt()))
}
