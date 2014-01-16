package models

import org.squeryl._

object TrackerSchema extends Schema {
  
	val inflationTable = table[Inflation]("INFLATION")
  
    val fundsTable = table[Fund]("FUND")
}