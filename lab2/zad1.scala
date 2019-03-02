object Main {
 def main(args: Array[String]) {
  print("Podaj n: ")
  var n = io.StdIn.readInt()
  var tablicaNapisow = new Array[String](n)
  var i = 0
  while(i<n) {
	  print("Podaj napis do tablicy: ")
	  tablicaNapisow(i) = io.StdIn.readLine()
	  i=i+1
  }
  i = 0;
  while (i < n) {
	var j = i + 1
	var temp = ""
    while (j < n) {
		if (tablicaNapisow(i).length == tablicaNapisow(j).length) {
			if (tablicaNapisow(i) > tablicaNapisow(j)) {
				temp = tablicaNapisow(i)
                tablicaNapisow(i) = tablicaNapisow(j)
                tablicaNapisow(j) = temp   
            }
		} else if (tablicaNapisow(i).length > tablicaNapisow(j).length) {
                temp = tablicaNapisow(i);
                tablicaNapisow(i) = tablicaNapisow(j);
                tablicaNapisow(j) = temp;
		}
        j=j+1;
    }
        i=i+1;
    }
    println("Posortowane: ");
    i = 0;
    while (i < n) {
        println(tablicaNapisow(i));
        i=i+1;
    }
 }
}
