package example

import scala.concurrent.duration._

import cats.effect._
import fs2.Stream
import org.http4s._
import org.http4s.dsl.io._

// An infinite stream of the periodic elapsed time
val seconds = Stream.awakeEvery[IO](1.second)

val routes = HttpRoutes.of[IO] {
  case GET -> Root =>
    Ok("Hello http4s!")
  case GET -> Root / "seconds" =>
    Ok(seconds.map(_.toString + "\n"))
}
