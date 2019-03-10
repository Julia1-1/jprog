import scala.annotation.tailrec

object zad3 {
   def policz(str: String): Int = {
     @tailrec
     def rekurencja(str: String,i: Int,licznik: Int): Int = {
       if(str.length == i) {
         licznik
       } else {
         if (str(i) < 'a' || str(i) > 'z') {
           rekurencja(str, i + 1, licznik)
         } else {
           rekurencja(str, i + 1, licznik + 1)
         }
       }
     }
     rekurencja(str, 0,0)
   }
  println("Liczba malych liter:" + policz("INforMAtyka jeSt oK"))

}
