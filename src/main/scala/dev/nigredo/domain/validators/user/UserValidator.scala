package dev.nigredo.domain.validators.user

import cats.instances.list._
import cats.syntax.cartesian._
import dev.nigredo.ValidationResult
import dev.nigredo.domain.model.{User => DomainUser}
import dev.nigredo.domain.model.User.{Name, Password}

object UserValidator extends ((Name, Password) => ValidationResult[DomainUser]) {
  override def apply(name: Name, pwd: Password): ValidationResult[DomainUser] =
    (common.Name(name) |@| common.Password(pwd)).map(DomainUser.apply)
}
