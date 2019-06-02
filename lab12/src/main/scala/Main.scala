import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated}

case class Init(liczbaPracownikow: Int)
case class Zlecenie(tekst: List[String])
case class Wykonaj(tekst: String)
case class Wynik(wynik: Int)

class Nadzorca extends Actor {
  def receive: Receive = {
    case Init(x) =>
      def createWorkers(zbior: Set[ActorRef], ile: Int): Seq[ActorRef] = {
        ile match {
          case 0 => zbior.toSeq
          case _ =>
            val pracownik = context.actorOf(Props[Pracownik], "pracownik"+zbior.size)
            context.watch(pracownik)
            createWorkers(zbior + pracownik,ile-1)
        }
      }
      context.become(getOrder(createWorkers(Set.empty,x)))
  }

  def getOrder(zbiorPracownikow: Seq[ActorRef]): Receive = {
    case Zlecenie(tekst) =>
      println(tekst.flatMap(_.split("\n")))
      context.become(getResults(zbiorPracownikow.toSet,wysylanieZlecen(zbiorPracownikow,tekst.flatMap(_.split("\n"))),0))

      def wysylanieZlecen(zbiorPracownikow: Seq[ActorRef], tekst: List[String]): List[String] = (zbiorPracownikow,tekst) match {
        case (Seq(), tekst) => tekst
        case (p1 +: pn,t1 +: tn) =>
          p1 ! Wykonaj(t1)
          wysylanieZlecen(pn,tn)
      }
  }

  def getResults(zbiorPracownikow: Set[ActorRef], resztaTekstu: List[String],suma:Int): Receive = {
    case Wynik(x) =>
      val suma2 = suma + x
      resztaTekstu match {
        case List() => context.stop(sender())
          context.become(getResults(zbiorPracownikow, resztaTekstu, suma2))
        case t1 +: tn => sender() ! Wykonaj(t1)
          context.become(getResults(zbiorPracownikow, tn, suma2))
      }

    case Terminated(pracownik) =>
      val pracujacy = zbiorPracownikow - pracownik
      if(pracujacy.isEmpty) {
        println("Ilosc slow: " + suma)
        context.become(getOrder(zbiorPracownikow.toSeq))
      }
      context.become(getResults(pracujacy,resztaTekstu,suma))
  }
}

class Pracownik extends Actor {
  def receive: Receive = {
    case Wykonaj(wierszTekstu) =>
      sender() ! Wynik(wierszTekstu.split(" ").count(_ != ""))
  }
}

object Main extends App {
  def dane(): List[String] = {
    scala.io.Source.fromResource("ogniem_i_mieczem.txt").getLines.toList
  }

  val system = ActorSystem("sys")
  val nadzorca = system.actorOf(Props[Nadzorca], "nadzorca")
  nadzorca ! Init(4)
  nadzorca ! Zlecenie(dane())
}