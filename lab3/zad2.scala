import scala.annotation.tailrec

object zad2 {
  def palindrom(tablica: Array[Int]): Boolean = {
    @tailrec
    def rekurencja(tablica: Array[Int], i: Int): Boolean = {
      if(tablica.length/2 == i) {
        true
      } else {
        if (tablica(tablica.length - i - 1) == tablica(i))
          rekurencja(tablica, i - 1)
        else
          false
      }
    }
    rekurencja(tablica, tablica.length-1)
  }

  var tablica = Array(3, 4, 5, 4,3)

  if(palindrom(tablica)) {
    println("Tablica jest palindromem")
  } else {
    println("Tablica nie jest palindromem.")
  }
}
