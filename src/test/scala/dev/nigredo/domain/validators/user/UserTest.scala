package dev.nigredo.domain.validators.user

import dev.nigredo.domain.model.User.{Name, Password}
import org.scalatest.{FunSuite, Matchers}

class UserTest extends FunSuite with Matchers {

  test("Create new user with invalid name and pass")(UserValidator(Name("s"), Password("test")).isInvalid shouldBe true)

  test("Create new user with invalid name")(UserValidator(Name("s"), Password("testtesttest")).isInvalid shouldBe true)

  test("Create new user with invalid pass")(UserValidator(Name("CorrectName"), Password("223")).isInvalid shouldBe true)

  test("Create new valid user")(UserValidator(Name("Correctname"), Password("CorrectPassword")).isValid shouldBe true)
}
