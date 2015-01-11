import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

object Hi extends App {
  println("Good day to you sir")

val service = (new generated.HelloWorldServiceSoapBindings with scalaxb.Soap11ClientsAsync with scalaxb.DispatchHttpClientsAsync {}).service
val fresponse = service.hello(Some("MICHAEL CAINE"))
val response = Await.result(fresponse, 5 seconds)
println(response)

}
