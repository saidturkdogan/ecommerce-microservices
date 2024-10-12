import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.actor.ActorSystem

object WebServer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("my-system")
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get{
          complete("Hello Scala")
        }
      }

    val bindingFuture = Http().newServerAt("localhost",8181).bind(route)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")

  }

}
