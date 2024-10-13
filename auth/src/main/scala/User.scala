import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._

case class User(name: String, email: String)

object User {
  implicit val format = jsonFormat2(User.apply)
}

object MyWebServer {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("my-system")
    implicit val executionContext = system.dispatcher

    val route = {
      cors(){
        path("users") {
          get {
            complete(User("John Doe", "johndoe@example.com"))
          } ~
            post {
              entity(as[User]) { user =>
                complete(s"Posted user: ${user.name}")
              }
            }
        }
      }
    }



    val bindingFuture = Http().newServerAt("localhost", 8181).bind(route)
    println("Server online at http://localhost:8181/\nPress RETURN to stop...")
  }
}
