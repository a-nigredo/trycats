package dev.nigredo.dao

import cats.data.Reader
import cats.syntax.applicative._
import dev.nigredo.domain.model.User
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait UserDao {

  type DbReader[A] = Reader[Db, A]

  def findOneById(id: Long): DbReader[Future[Option[User]]] = new DbReader(x => Future.successful(x.users.values.find(_.id == id)))

  def save(user: User): DbReader[Future[User]] = Future.successful(user).pure[DbReader]
}

case class Db(users: Map[Int, User])
