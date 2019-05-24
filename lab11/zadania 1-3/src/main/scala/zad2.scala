import akka.actor._

case class Wyslij(a: Double, b: Double, c: Double, serwer: ActorRef)
case class Sprawdz(a: Double, b: Double, c: Double)

class Klient extends Actor {
    def receive: Receive = {
        case Wyslij(a,b,c,serwer) => serwer ! Sprawdz(a,b,c)
        case x:Boolean if(x) => println("Mozna utworzyc trojkat")
        case _ => println("Nie mozna utworzyc trojkata")
    }
}

class Serwer extends Actor {
    def receive: Receive = {
    case Sprawdz(a,b,c) if(a+b>=c && a+c>=b && c+b>=a) => sender() ! true
    case _ => sender() ! false
    }
}
object Main2 extends App {
    val system = ActorSystem("sys")
    val klient = system.actorOf(Props[Klient], "klient")
    val serwer = system.actorOf(Props[Serwer], "serwer")

    //klient ! Wyslij(1,2,8,serwer)
    klient ! Wyslij(3,4,5,serwer)
    system.terminate()
}