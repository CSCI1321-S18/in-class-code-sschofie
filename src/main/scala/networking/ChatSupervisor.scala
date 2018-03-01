package networking

import java.io.BufferedReader
import java.io.PrintStream
import java.net.Socket

import akka.actor.Actor
import akka.actor.Props

class ChatSupervisor extends Actor{
  import ChatSupervisor._
  def receive = {
    case ProcessInput =>
        for(child <- context.children) child ! Chatter.ProcessInput
    case NewChatter(name, sock, in, out) =>
      context.actorOf(Props(new Chatter(name, sock, in, out)), name)
    case SendMessage(msg) =>
      for(child <- context.children) child ! Chatter.PrintMessage(msg)
    case m=> println(s"Bad message in ChatSupervisor: $m")
  }
}

object ChatSupervisor{
  case object ProcessInput
  case class NewChatter(name: String, sock: Socket, in: BufferedReader, out: PrintStream)
  case class SendMessage(msg: String)
}