object Main5 {
 def main(args: Array[String]) {
	 print("Podaj liczbę: ")
	 var liczba1 = io.StdIn.readInt()
	 var x = 2
	 var znacznik = 0
	 while(liczba1>x) {
		 if(liczba1%1==0 && liczba1%x==0) {
				 println("Liczba nie jest pierwsza.")
				 x=liczba1+1
				 znacznik = 1
		 } else {
				 x=x+1
		 }
				 
		 }
		 if ( znacznik == 0 ) {
			 if(liczba1%1==0 && liczba1%liczba1==0) {
				 println("Liczba jest pierwsza.")
			 }
		 }
	 
 } 
}
