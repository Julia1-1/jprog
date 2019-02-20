object Main2 {
 def main(args: Array[String]) {
	 print("Podaj liczbę: ")
  var liczba = io.StdIn.readInt()
  if(liczba%2==0) {
	  println("Liczba "+liczba+" jest parzysta.")
  } else {
	  println("Liczba "+liczba+" jest nieparzysta.")
  }
	  
 }
}
