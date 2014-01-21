package models

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.dsl._

case class Fund (id: Long, code: String, name: String, currency: String) extends KeyedEntity[Long] {
  lazy val investment: OneToMany[Investment] = TrackerSchema.fundToInvestments.left(this)
  lazy val rate: OneToMany[Rate] = TrackerSchema.fundToRates.left(this)
}