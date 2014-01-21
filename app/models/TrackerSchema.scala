package models

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

object TrackerSchema extends Schema {
  
	val inflations = table[Inflation]("INFLATION")
  
    val funds = table[Fund]("FUND")
    
    val investments = table[Investment]("INVESTMENT")
    
    val investors = table[Investor]("INVESTOR")
    
    val rates = table[Rate]("RATE")
        
    val fundToInvestments =
    	oneToManyRelation(funds, investments).via(
    	    (f, i) => f.id === i.fundId
    	)
    	
    val investorToInvestments =
    	oneToManyRelation(investors, investments).via(
    	    (ior, ivm) => ior.id === ivm.investorId
    	)
    	
	val fundToRates =
    	oneToManyRelation(funds, rates).via(
    	    (f, r) => f.id === r.fundId
    	)
}