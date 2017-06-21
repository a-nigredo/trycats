package dev.nigredo.dto

import dev.nigredo.domain.model.User.{Name, Password}

case class NewUserDto(name: Name, pwd: Password)
case class UpdateUserDto(name: Option[Name], pwd: Option[Password])
