package dev.nigredo.dao

import cats.Monad


trait Dao[A, R] {
  def create[M[_] : Monad](entity: M[A]): M[R]

  def findOne[M[_]: Monad, F](entity: M[F]): M[R]
}
