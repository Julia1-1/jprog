object Main2 {
 def main(args: Array[String]) {
  print("Podaj pierwsza liczbe: ")
  var liczba1 = io.StdIn.readLine()
  print("Podaj druga liczbe: ")
  var liczba2 = io.StdIn.readLine()

  var dlugoscp = liczba1.length
  var dlugoscd = liczba2.length
  var i = 1
  var j = 1
  var calosc = 0
  var temp = 0
      while(dlugoscp >= i || dlugoscd >= i) {
          if(dlugoscp >= i)
            temp += liczba1(dlugoscp-i) - '0'
          if(dlugoscd >= i)
            temp += liczba2(dlugoscd-i) - '0'
        calosc = calosc + temp*j
        j=j*10
        i=i+1
        temp=0
  }
  println(calosc)
    
  
 }
}