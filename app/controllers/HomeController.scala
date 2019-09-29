package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import java.security.MessageDigest
import java.math.BigInteger
import java.net.InetSocketAddress

import spray.json._
import akka.actor._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import akka.actor.ActorSystem
import akka.io.Udp.SimpleSender
import akka.stream.{ActorMaterializer, Materializer}
import play.api.libs.streams.ActorFlow

import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout
import services.JTello

import sys.process._


@Singleton
class HomeController @Inject()(cc: ControllerComponents, jt: JTello) extends AbstractController(cc) {

  implicit val timeout: Timeout = 15.seconds
  implicit val system = ActorSystem("RemoteActorSystem")
  implicit val materializer = ActorMaterializer()

  def index = Action {implicit request =>

    Ok(views.html.index("Your new application is ready."))
  }

  def sendRequest(command: String) =  Action { implicit request =>

    val res = command match {
      case "connect" =>
        jt.isConnected match {
          case true => "already connected!"
          case false => jt.connect
        }
      case "battery" => jt.getBattery
      case "takeoff" => jt.takeOff
      case "land" => jt.land
      case _ => "invalid command"
    }
    Ok(res.toString)
  }

}
