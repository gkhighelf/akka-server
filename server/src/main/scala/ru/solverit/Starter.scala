package ru.solverit

import akka.actor.{Props, ActorSystem}
import com.awar.ags.config.SConfig
import com.awar.ags.tasks.TaskService
import ru.solverit.core.TaskService
import ru.solverit.tcpfront.AkkaNetServerTCP

object Starter extends App {

  // create the actor system and actors
  val actorSystem = ActorSystem( "server" )

  val actorTasks = actorSystem.actorOf( Props( new TaskService() ), "task" )
  val actorNet = actorSystem.actorOf( Props( new AkkaNetServerTCP( "127.0.0.1", 8888 ) ), "front" )
}