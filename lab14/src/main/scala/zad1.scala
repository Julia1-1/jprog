import akka.actor.{Actor, ActorSystem, Props}

case class Odbierz(wiadomosc: String)
case object Wyswietl

class Nadzorca extends Actor {
    def receive: Receive = {
        case Odbierz(wiadomosc: String) => 
        context.become(odbieranie(wiadomosc))
    }

    def odbieranie(wiadomosc: String): Receive = {
        case Wyswietl => println(wiadomosc)
    }
}

object Main extends App {
    val system = ActorSystem("sys")
    val nadzorca = system.actorOf(Props[Nadzorca], "nadzorca")
    nadzorca ! Odbierz("Wiadomosc")
    nadzorca ! Wyswietl
    system.terminate()
  
}