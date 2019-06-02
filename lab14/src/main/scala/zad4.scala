import akka.actor._

case class Init(n:Int)
case class Silnia(liczba: Int)

class Nadzorca2 extends Actor {
    def receive: Receive = {
        case Init(n) =>
            context.become(koniecPracy(stworzPracownikow(Set.empty,n)))

            def stworzPracownikow(zbior: Set[ActorRef], n:Int): Set[ActorRef] = n match {
                case 0 => zbior
                case n =>
                    val pracownik = context.actorOf(Props[Pracownik],"pracownik0"+n)
                    context.watch(pracownik)
                    pracownik ! Silnia(n)
                    stworzPracownikow(zbior+pracownik,n-1)
            }
    }

    def koniecPracy(zbior: Set[ActorRef]) :Receive = {
        case Terminated(pracownik) =>
            val pracownicy = zbior - pracownik
            if(pracownicy.isEmpty) {
                println("Wszyscy pracownicy zakonczyli prace")
            }
            context.become(koniecPracy(pracownicy))
    }
}

class Pracownik extends Actor {
    def receive: Receive = {
        case Silnia(n) => println("Wynik "+n+"! = "+obliczanie(n,1))
            context.stop(self)
            sender() ! self
    }

    def obliczanie(silnia: Int, wynik: Int): Int = {
        silnia match {
            case 1 => wynik
            case n => obliczanie(silnia-1,wynik*n)
        }
    }
}

object Main4 extends App {
    val system = ActorSystem("sys")
    val nadzorca = system.actorOf(Props[Nadzorca2], "nadzorca")
    nadzorca ! Init(5)
}