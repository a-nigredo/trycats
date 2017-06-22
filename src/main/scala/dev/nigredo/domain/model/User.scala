package dev.nigredo.domain.model

import dev.nigredo.domain.model.User.{Name, Password}

import scala.util.Random

case class User(id: Int, name: Name, password: Password)

object User {

  def apply(name: Name, pass: Password): User = User(Random.nextInt(), name, pass)

  case class Password(value: String) extends AnyVal

  case class Name(value: String) extends AnyVal

}
