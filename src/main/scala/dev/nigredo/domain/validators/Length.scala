package dev.nigredo.domain.validators

object Length {

  def >(min: Int)(value: String): Boolean = value.length >= min

  def <(max: Int)(value: String): Boolean = value.length <= max
}
