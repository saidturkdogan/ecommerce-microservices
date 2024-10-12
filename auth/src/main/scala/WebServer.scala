import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.actor.ActorSystem

object WebServer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("my-system")
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get {
          complete("asdasda")
        }
      }


    val bindingFuture = Http().newServerAt("localhost",4444).bind(route)
    println(s"Server online at http://localhost:4444/\nPress RETURN to stop...")

  }

}
