package models

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.dsl._
import java.util.Date

case class Investment (id: Long, fundId: Long, investorId: Long, date: Date, quantity: Long) extends KeyedEntity[Long] {
  lazy val fund: ManyToOne[Fund] = TrackerSchema.fundToInvestments.right(this)
  lazy val investor: ManyToOne[Investor] = TrackerSchema.investorToInvestments.right(this)
}
