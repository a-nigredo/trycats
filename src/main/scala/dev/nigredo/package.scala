package dev

import cats.data.{EitherT, Validated}

package object nigredo {

  sealed trait Error

  type Result[M[+ _], A] = EitherT[M, Error, A] //will be M[Either[Error, A]]
  type ValidationResult[A] = Validated[List[String], A]
}
