package example

import cats.effect._
import org.http4s.ember.server.EmberServerBuilder

def run = EmberServerBuilder
  .default[IO]
  .withHttpApp(routes.orNotFound)
  .build
  .useForever
