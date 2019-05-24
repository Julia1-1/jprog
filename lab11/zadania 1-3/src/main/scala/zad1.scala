import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case class Graj(przeciwnik: ActorRef)
case object Ping
case object Pong



class Gra extends Actor {
  def receive: Receive = {
    case Graj(przeciwnik) => {
      przeciwnik ! Ping }
    case Ping => {
      println("Ping")
      sender() ! Pong }
    case Pong => {
      println("Pong")
      sender() ! Ping
    }
  }
}


object Main extends App {
  val system = ActorSystem("sys")
  val pierwszy = system.actorOf(Props[Gra], "pierwszy")
  val drugi = system.actorOf(Props[Gra], "drugi")

  pierwszy ! Graj(drugi)
}