import akka.actor._

case class PrzyjmijWiadomosc(wiadomosc: String)

class Przyjmujacy extends Actor with Stash {
    def receive: Receive = {
        case PrzyjmijWiadomosc("zmien")=>
            unstashAll()
            context.become(wypisz)
        case PrzyjmijWiadomosc(wiadomosc) => stash()
    }

    def wypisz: Receive = {
            case PrzyjmijWiadomosc(msg) => println("Wczesniej bylo: " + msg)
    }
}

object Main2 extends App {
    val system = ActorSystem("sys")
    val nadzorca = system.actorOf(Props[Przyjmujacy], "nadzo")
    nadzorca ! PrzyjmijWiadomosc("Wiadomosc1")
    nadzorca ! PrzyjmijWiadomosc("Wiadomosc22")
    nadzorca ! PrzyjmijWiadomosc("Wiadomosc123")
    nadzorca ! PrzyjmijWiadomosc("zmien")
    system.terminate()

}