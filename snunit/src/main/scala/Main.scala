package example

import cats.effect.IO
import snunit.http4s.SNUnitServerBuilder
import epollcat.EpollApp

object Main extends EpollApp.Simple {

  def run = SNUnitServerBuilder
    .default[IO]
    .withHttpApp(routes.orNotFound)
    .build
    .useForever
}
