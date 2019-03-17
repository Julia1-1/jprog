object zad3 {
  type MSet[A] = A => Int
  def +[A](s1: MSet[A], s2: MSet[A]): MSet[A] = {
    a: A => s1(a) + s2(a)
  }

  def -[A](s1: MSet[A], s2: MSet[A]): MSet[A] = {
    b: A => {
      if (s1(b) - s2(b) < 0) 0
      else s1(b) - s2(b)
    }
  }

  def &[A](s1: MSet[A], s2: MSet[A]): MSet[A] = {
    c: A => s1(c) min s2(c)
  }


}
