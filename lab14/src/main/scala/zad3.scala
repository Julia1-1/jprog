import akka.actor._

case class Wynik(liczba1: Double, liczba2: Double)
case object Zmien

class Pracownik2 extends Actor {
    def receive: Receive = {
        case Wynik(l1, l2) => println("Suma: "+(l1+l2))
        case Zmien => context.become(iloczyn)
    }

    def iloczyn: Receive = {
    case Wynik(l1,l2) => println("Iloczyn: "+l1*l2)
    case "powrot" => context.become(receive)
    }
}

object Main3 extends App {
    val system = ActorSystem("system")
    val pracownik = system.actorOf(Props[Pracownik2],"pracownik")
    pracownik ! Wynik(4,2)
    pracownik ! Zmien
    pracownik ! Wynik(5,9)
    pracownik ! "powrot"
    pracownik ! Wynik(6,4)
}