package dev

import cats.data.{Validated, Writer}

package object nigredo {

  sealed trait Error

  case class ValidationsError(msg: List[String]) extends Error

  type Result[A] = Either[Error, A]
  type LoggedResult[A] = Result[Writer[Vector[String], A]]
  type ValidationResult[A] = Validated[List[String], A]
}
