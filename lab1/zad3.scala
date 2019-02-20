object Main3 {
 def main(args: Array[String]) {
	 var dodatnie = 0
	 var ujemne = 0
	 print("Podaj liczbę: ")
	 var liczba = io.StdIn.readDouble()
	 if(liczba>0) {
		  dodatnie=dodatnie+1
	  } else if (liczba < 0) {
		  ujemne = ujemne + 1
	  }
	 while ( liczba != 0) {
		 print("Podaj liczbę: ")
		 liczba = io.StdIn.readDouble()
	  if(liczba>0) {
		  dodatnie=dodatnie+1
	  } else if (liczba < 0) {
		  ujemne = ujemne + 1
	  }
	 }
	 println("Ilosc liczb dodatnich: "+dodatnie)
	 println("Ilosc liczb ujemnych: "+ujemne)
 } 
}
