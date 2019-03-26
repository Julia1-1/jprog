import scala.annotation.tailrec

object Main4 {

//-----------------------przyklad a--------------------------------
  def size[A](seq: Seq[A]): Int = {
    @tailrec
    def compute[A,B](seq: Seq[A])(init: Int)(op: (Int, Int) => Int): Int = {
      seq match {
        case (a1 +: an) => compute(an)(op(1,init))(op)
        case Seq() => init
      }
    }
    compute(seq)(0)(_ + _)
  }

  val seq = Seq(1,6,2,8,3)
  println("Przykład a: " + size(seq))


//-------------------------przyklad b-------------------------------
  def reverse[A](seq: Seq[A]): Seq[A] = {
    @tailrec
    def compute[A](seq: Seq[A])(init: Seq[A])(op: (Seq[A], A) => Seq[A]): Seq[A] = {
      seq match {
        case (pocz :+ kon) => compute(pocz)(op(init, kon))(op)
        case Seq() => init
      }
    }
    compute(seq)(Seq.empty)(_ :+ _)
  }

  val seq2 = Seq(1,5,2,7)
  println("Przyklad b: "+ reverse(seq2))


//-------------------------przyklad c-------------------------------
  def applyForAll[A](seq: Seq[A], g: g[A]): Seq[A] = {
    @tailrec
    def compute[A](seq: Seq[A])(init: Seq[A])(op: (Seq[A], A) => Seq[A])(g: g[A]): Seq[A] = {
      seq match {
        case (a1 +: an) => compute(an)(op(init, g(a1)))(op)(g)
        case Seq() => init
      }
    }
    compute(seq)(Seq.empty)(_ :+ _)(g)
  }
  type g[A] = A => A
  val seq3 = Seq(2,0,1,3,10)
  val g: g[Int] = (x : Int) => x*x
  println("Przyklad c: "+ applyForAll(seq3, g))


//-------------------------przyklad d-------------------------------
  def filter[A](seq: Seq[A], f: f[A]): Seq[A] = {
    @tailrec
    def compute[A](seq: Seq[A])(init: Seq[A])(op: (Seq[A], A) => Seq[A])(f: f[A]): Seq[A] = {
      seq match {
        case (a1 +: an) =>
          if(f(a1))
            compute(an)(op(init, a1))(op)(f)
          else compute(an)(init)(op)(f)
        case Seq() => init
      }
    }
    compute(seq)(Seq.empty)(_ :+ _)(f)
  }
  val seq4 = Seq(1,3,5,6)
  type f[A] = A => Boolean
  val f : f[Int] = (n: Int) => n%3 == 0
  println("Przyklad d: "+filter(seq4,f))


//-------------------------przyklad e-------------------------------
  @tailrec
 def forall[A](seq: Seq[A], h: h[A]): Boolean = {
   seq match {
     case (a1 +: an) =>
       if(h(a1)) forall(an, h)
       else false
     case Seq() => true
   }
 }

  type h[A] = A => Boolean
  val h: h[Int] = (n: Int) => n%4==0
  val seq5 = Seq(12,4,64,33)
  println("Przyklad e: "+forall(seq5, h))

}
