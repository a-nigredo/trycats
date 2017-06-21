package dev.nigredo.domain.validators.user.common

import dev.nigredo.ValidationResult
import dev.nigredo.domain.model.User.{Password => UserPassword}
import dev.nigredo.domain.validators.{Length, predicate}

private[user] object Password extends (UserPassword => ValidationResult[UserPassword]) {
  override def apply(pwd: UserPassword): ValidationResult[UserPassword] = predicate[UserPassword](pwd, x => Length.>(7)(x.value), "Password has to be more than 7 symbol")
}
