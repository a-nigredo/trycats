package dev.nigredo.domain.validators

import cats.Eq

object TheSame {
  def apply[A](data: (A, A))(implicit ev: Eq[A]): Boolean = ev.eqv(data._1, data._2)
}
