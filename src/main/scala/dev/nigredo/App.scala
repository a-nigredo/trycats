package dev.nigredo

import cats.{Id, Monad}
import cats.data.{EitherT, Kleisli, OptionT, ReaderT}
import cats.syntax.either._
import cats.syntax.writer._
import cats.instances.future._
import cats.syntax.applicative._
import cats.instances.vector._
import dev.nigredo.dao.{Db, UserDao}
import dev.nigredo.domain.model.User
import dev.nigredo.domain.model.User.{Name, Password}
import dev.nigredo.domain.services.UserService
import dev.nigredo.domain.validators.user.UserValidator
import dev.nigredo.dto.NewUserDto

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import cats.instances.future._

import scala.util.Try

object App {
  def main(args: Array[String]): Unit = {

    val userDto = NewUserDto(Name("name"), Password("password"))
    val user = User(1, Name("Andrey"), Password("Test"))
    val db = Db(Map(user.id -> user))
    val userDao = new UserDao {}
    val userService = new UserService {}
//    val res = userDao.findOneById(1).map { x =>
//      for {
//        v <- x
//        v2 <- userDao.save(v.get)
//      } yield v
//    }


    val res = userDao.findOneById(1).map(x => OptionT(x).map(userDao.save))//.andThen(x => OptionT(x)(userDao.save))

//    val res = (for {
//      v <- userDao.findOneById(1)
//      v2 <- userDao.save(v)
//    } yield v).run(db)

//    val us = new UserService {}
//
//    val res = us.create(User(Name("test"), Password("passss"))).run(new UserDao {})

//    def multiply(i1: Int, i2: Int): LoggedResult[Int] = 1.writer(Vector(s"Multiple $i1 * $i2")).asRight
//
//    val res = for {
//      v1 <- EitherT(multiply(2, 2).pure[Future])
//      _ = v1.mapWritten(_.foreach(println))
//      v2 <- EitherT(multiply(2, v1.value).pure[Future])
//      _ = v2.mapWritten(_.foreach(println))
//    } yield v2
//
    println(Await.result(res.run(db).value, Duration.Inf))
  }
}
