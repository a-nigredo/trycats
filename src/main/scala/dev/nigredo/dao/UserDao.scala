package dev.nigredo.dao

import dev.nigredo.domain.model.User
import dev.nigredo.domain.model.User.{Name, Password}

import scala.concurrent.Future

trait UserDao {
  def findOneById(id: Long): Future[Option[User]] = Future.successful(if(id == 1) None else Option(User(Name("Andrey"), Password("pwd"))))
}
