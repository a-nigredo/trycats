package dev.nigredo.domain.validators

object NonEmpty extends (String => Boolean) {
  override def apply(v1: String): Boolean = v1.nonEmpty
}
