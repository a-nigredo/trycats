package dev.nigredo.domain.services

import cats.data.Reader
import cats.syntax.either._
import cats.{Monad, Show}
import dev.nigredo.dao.Dao
import dev.nigredo.{LoggedResult, Result, ValidationResult, ValidationsError}
//trait BaseService[A] extends Service[A, Result[A], A] {
//  override def create[M[_] : Monad](entity: M[A]): M[Result[A]] = entity.map(x => baseFlow(x).map(dao.create))
//}

abstract class LoggedService[A](implicit msg: Show[A]) extends Service[A, LoggedResult[A], A] {
  override def create[M[_] : Monad](entity: M[A]): M[Reader[Dao[A, M[A]], LoggedResult[A]]] = ???
//    entity.map(x => Reader(dao =>
//      for {
//        bf <- baseFlow(x)
//        result <- dao.create(bf)
//      } yield Writer(Vector(msg.show(x)), result)
//    ))
}

//      baseFlow(x).map(x => Writer(Vector(msg.show(x)), dao.create(x)))

trait Service[A, R, R2] {

  val validator: A => ValidationResult[A]

  def create[M[_] : Monad](entity: M[A]): M[Reader[Dao[A, M[R2]], R]]

  protected[services] def baseFlow(x: A): Result[A] = validator(x).toEither.leftMap(ValidationsError)
}


