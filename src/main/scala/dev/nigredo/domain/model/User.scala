package dev.nigredo.domain.model

import dev.nigredo.domain.model.User.{Name, Password}

case class User(name: Name, password: Password)

object User {

  case class Password(value: String) extends AnyVal

  case class Name(value: String) extends AnyVal

}
