package com.samvan.bot

import scalaz.zio._
import scalaz.zio.console._
import scalaz.zio.random._

object BotRunner extends App {
  val environment = new Console.Live with Random.Live with FileReader.Live

  def handleError(error: Any): ZIO[Console, Nothing, Int] = for {
    _      <- console.putStrLn(s"An error occured: ${error}\nWith type: ${error.getClass}")
    result <- run(List.empty)
  } yield result

  def run(args: List[String]): ZIO[Console, Nothing, Int] =
    Bot.startBot(1)
      .provide(environment)
      .foldM(handleError, _ => ZIO.succeed(0))
}
