package dev.nigredo.domain.services

import cats.data.Reader
import dev.nigredo.LoggedResult
import dev.nigredo.dao.UserDao
import dev.nigredo.domain.model.User
import cats.syntax.writer._
import cats.instances.vector._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait UserService {

  type Response[A] = Reader[UserDao, Future[LoggedResult[A]]]

  def create(user: User): Response[User] = ???

  //    Reader(dao => dao.save(user).map(u => Right(u.writer(Vector(s"User ${u.id} has been saved")))))
}
