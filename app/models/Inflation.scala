package models

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

case class Inflation (val id: Long = 0, val currency: String, val year: Int, val rate: Float) extends KeyedEntity[Long]
