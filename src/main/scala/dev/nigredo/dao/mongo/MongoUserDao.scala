package dev.nigredo.dao.mongo

import cats.Monad
import dev.nigredo.dao.Dao
import dev.nigredo.domain.model.User
import org.mongodb.scala.MongoCollection
import cats.syntax.flatMap._

trait UserDao extends Dao[User, User] {

  val collection: MongoCollection[User]

  override def create[M[_] : Monad](entity: M[User]): M[User] = ???

  override def findOne[M[_] : Monad, F](entity: M[F]): M[User] =
    entity.flatMap(x => collection.find().head())
}
