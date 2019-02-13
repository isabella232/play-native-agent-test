package com.rollbar.dev

import com.rollbar.notifier.Rollbar
import com.rollbar.notifier.config.ConfigBuilder
import play.api.mvc._
import scala.collection.JavaConverters._

class Application extends Controller {
  val config = ConfigBuilder.withAccessToken(System.getenv("RB"))
    .environment("agent-test")
    .appPackages(List("com.rollbar.dev").asJava)
    .build

  val rollbar = Rollbar.init(config)

  def index() = Action {
    try
      throw new Error("x")
    catch {
      case e: Throwable =>
        rollbar.error(e)
    }

    Ok("Reported")
  }
}
