package models

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.dsl._

case class Investor (id: Long, name: String, fee: Long, chargePeriod: String) extends KeyedEntity[Long] {
    //lazy val investment: OneToMany[Investment] = TrackerSchema.investorToInvestments.left(this)
}