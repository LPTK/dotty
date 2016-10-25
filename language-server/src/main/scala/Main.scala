import java.util.function.Consumer

import java.net._

import io.typefox.lsapi._
import io.typefox.lsapi.services._
import io.typefox.lsapi.services.json._
import io.typefox.lsapi.annotations._
import io.typefox.lsapi.services.transport.server._
import io.typefox.lsapi.services.transport.trace._

object Main {
  def main(args: Array[String]): Unit = {

    val serverSocket = new ServerSocket(6004)
    Runtime.getRuntime().addShutdownHook(new Thread(
      new Runnable {
        def run: Unit = {
          serverSocket.close()
        }
      }));

    val server = new ScalaLanguageServer

    println("hi")
    val clientSocket = serverSocket.accept()
    println("accepted")
    val in = clientSocket.getInputStream
    val out = clientSocket.getOutputStream
    //val in = System.in
    //val out = System.out

    val handler = new MessageJsonHandler
    val reader = new StreamMessageReader(in, handler)
    val writer = new StreamMessageWriter(out, handler)
    val endpoint = new LanguageServerEndpoint(server)

    endpoint.setMessageTracer(new MessageTracer() {
      override def onError(message: String, err: Throwable) {
        //println(s"onError: $message - $err")
        err.printStackTrace
      }
      override def onRead(msg: Message, s: String): Unit = {
        //println(s"onRead: $msg")
      }
      override def onWrite(msg: Message, s: String): Unit = {
        //println(s"onWrite: $msg")
      }
    })
    reader.setOnError(new Consumer[Throwable] {
      def accept(err: Throwable) = {
        //println(s"Reader: ${err.getMessage()}")
        throw err
      }
    })
    writer.setOnError(new Consumer[Throwable] {
      def accept(err: Throwable) = {
        //println(s"Writer: ${err.getMessage()}")
        throw err
      }
    })
    endpoint.connect(reader, writer)
  }
}
