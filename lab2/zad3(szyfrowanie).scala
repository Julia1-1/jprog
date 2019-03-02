object Main3 {
 def main(args: Array[String]) {
	   print("Podaj zdanie do zaszyfrowania: ")
	   var zdanieTemp = io.StdIn.readLine()
	   print("Podaj klucz: ")
	   var kluczTemp = io.StdIn.readLine()
	   var zdanie = ""
	   var klucz = ""
	   var i =0
	   var end = 0
	   while(i < zdanieTemp.length) {                  // usuwanie bialych znakow w zdaniu pierwszym 
		   if(zdanieTemp(i) == ' ' || zdanieTemp(i) == '	' || zdanieTemp(i) == '\n') {
			   var j = i
			   while(j < zdanieTemp.length) {
				   if(j+1!=zdanieTemp.length) {
					   if(zdanieTemp(j) != ' ' && zdanieTemp(j) != '	' && zdanieTemp(j) != '\n') {
							zdanie = zdanie + zdanieTemp(j+1)
						} else { 
							j=zdanieTemp.length+2
						}
					}
					j+=1
			   } 
			   
		   } else {
			   zdanie += zdanieTemp(i)
		   }
		   
		   i+=1
	   }
	   i = 0
	   while(i < kluczTemp.length) {                   // usuwanie bialych znakow w kluczu 
		   if(kluczTemp(i) == ' ' || kluczTemp(i) == '	' || kluczTemp(i) == '\n') {
			   var j = i
			   while(j < kluczTemp.length) {
				   if(j+1!=kluczTemp.length) {
					   if(kluczTemp(j) != ' ' && kluczTemp(j) != '	' && kluczTemp(j) != '\n') {
							klucz = klucz + kluczTemp(j+1)
						} else { 
							j=kluczTemp.length+2
						}
					}
					j+=1
			   } 
			   
		   } else {
			   klucz += kluczTemp(i)
		   }
		   
		   i+=1
	   }	   
	   kluczTemp = klucz
		while(kluczTemp.length < zdanie.length) {    //dopelnianie klucza jesli jest krotszy od zdania
			var i=0
			while(i<klucz.length) { 
			  if(kluczTemp.length != zdanie.length) {
			  kluczTemp = kluczTemp + klucz(i)
			  }
			  i=i+1
			}
		} 
		klucz = kluczTemp
	
	   println(zdanie)
	   println(klucz)
	   
	   
	   val alfabet = ('A' to 'Z').toArray
	   val rozmiarAlfabetu = alfabet.size
	   val tablicaKodu = Array.ofDim[Char](rozmiarAlfabetu, rozmiarAlfabetu)
	   i=0
	   while(i<rozmiarAlfabetu) {                       //uzupelnianie tablicy
		   var j=0
		   var x = i
		   while(j<rozmiarAlfabetu) {
			   if(rozmiarAlfabetu == x) {
				   x=0
			   }
			   tablicaKodu(i)(j) = alfabet(x)
			   x+=1
			   j+=1
		   }
		   i+=1
	   }
	   
	   i=0
	   var zakodowane = ""
	   while(i<zdanie.length) {                          //SZYFROWANIE
		   var x = alfabet.indexOf(zdanie(i))
		   var y = alfabet.indexOf(klucz(i))
		   zakodowane += tablicaKodu(x)(y)
		   i+=1
	   }
	   println(zakodowane)
	   
	   
	   
	   
	   
 }
}
