package dev.nigredo

import org.mongodb.scala.MongoClient

object App {

  def main(args: Array[String]): Unit = {

    // Use a Connection String
    val mongoClient = MongoClient("mongodb://localhost")
    val database = mongoClient.getDatabase("mydb")
    val col = database.getCollection("test")

//    get[List[User]].map(x => Future(col.find().map(_::x))).run(Nil).value

//    println(new UserDao{}.create(Option(User(Name("test"), Password("name")))))
//
//    implicit val defaultShow = Show.show[User](_.id.toString)
//
//    val service = new LoggedService[User]() {
//
//      override val validator: (User) => ValidationResult[User] = x => Left(List("error")).toValidated
//
//      override val dao = ???
//    }
//
//    val res = Await.result(service.create(Future(User(Name("yest"), Password("test")))), Duration.Inf)
//    res.bimap(println, x => x.mapWritten(println))
  }
}
