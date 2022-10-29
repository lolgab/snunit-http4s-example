package example

import cats.effect._
import org.http4s.ember.server.EmberServerBuilder

object Main extends epollcat.EpollApp.Simple {
  def run = example.run
}
