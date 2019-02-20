object Main4 {
 def main(args: Array[String]) {
	 print("Podaj pierwszą liczbę: ")
	 var liczba1 = io.StdIn.readInt()
	 print("Podaj drugą liczbę: ")
	 var liczba2 = io.StdIn.readInt()
	 while(liczba1!=liczba2) {
		 if(liczba1 > liczba2) {
			 liczba1 = liczba1 - liczba2
		 } else if (liczba1 < liczba2) {
			 liczba2 = liczba2 - liczba1
		 }
	 }
	 println("NWD tych liczb to: "+liczba1)
	 
 } 
}
