object zad2 {
  type Pred[A] = A => Boolean
  def and[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    (a : A) => p(a) && q(a)
  }

  def or[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    (a : A) => p(a) || q(a)
  }

  def not[A](p: Pred[A]): Pred[A] = {
    (a : A) => !p(a)
  }

  def imp[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    (a : A) => !p(a) || q(a)
  }

  def main(args: Array[String]) {

    var z : Pred[Int] = (x : Int) => x>2
    var y: Pred[Int] = (x : Int) => (x%2 == 0)
    if(and(z,y)(3)) {
      println("TAK")
    } else {
      println("NIE")
    }
  }

}
