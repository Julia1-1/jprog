object Main {
 def main(args: Array[String]) {
	 print("Podaj liczbę: ")
	 var liczba = io.StdIn.readInt()
	 if(liczba%2==0 && liczba>2) {
		 var pierwsza1 = 2
		 var czy = 0
		 var znacznik1 = 0
		 var znacznik2 = 0
		 while(liczba!=pierwsza1 && czy == 0 ) {
		 var x = 2
		 var pierwsza2 = liczba
		 pierwsza2 = pierwsza2 - pierwsza1
		 znacznik1=0
		 while(pierwsza2>x) {
			 if(pierwsza2%1==0 && pierwsza2%x==0) {
					 pierwsza1 = pierwsza1 + 1
					 x=pierwsza2+1
					 znacznik1 = 1
			 } else {
					 x=x+1
		 }
		 }
			if ( znacznik1 == 0 ) {
			 if(pierwsza2%1==0 && pierwsza2%pierwsza2==0) {
				 var y = 2
				 while(pierwsza1>y) {
			 if(pierwsza1%1==0 && pierwsza1%y==0) {
					 y=pierwsza2+1
					 znacznik2 = 1
			 } else {
					 y=y+1
		 }
		 if ( znacznik2 == 0 ) {
			 if(pierwsza1%1==0 && pierwsza1%pierwsza1==0) {
				 var suma = pierwsza1 + pierwsza2
				 println("Liczba spełnia hipotezę Goldbacha ("+pierwsza1 +"+"+ pierwsza2+"="+suma+")" )
				 czy = 1
			 }
		 } 
				 
			 }	 
		 }
		 
		 }
	 }
 }
}
}
	 
	 
	 
	 
	 
/* var znacznik = 0
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
*/
