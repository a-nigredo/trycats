package dev.nigredo.domain.validators.user.common

import dev.nigredo.ValidationResult
import dev.nigredo.domain.model.User.{Name => UserName}
import dev.nigredo.domain.validators.{Length, predicate}

private[user] object Name extends (UserName => ValidationResult[UserName]) {
  override def apply(name: UserName): ValidationResult[UserName] = predicate[UserName](name, x => Length.>(2)(x.value), "Name has to be more than 2 symbol")
}
