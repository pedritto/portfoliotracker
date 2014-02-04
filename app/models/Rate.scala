package models

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.dsl._
import java.util.Date

case class Rate (id: Long, fundId: Long, date: Date, price: Float) extends KeyedEntity[Long] {
  //lazy val fund: ManyToOne[Fund] = TrackerSchema.fundToRates.right(this)
}