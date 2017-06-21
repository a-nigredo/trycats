package dev.nigredo.domain

import cats.syntax.either._
import dev.nigredo.ValidationResult

package object validators {

  private[validators] def predicate[A](arg: A, body: A => Boolean, errorMsg: String): ValidationResult[A] = Right(arg).ensure(List(errorMsg))(body).toValidated
}
