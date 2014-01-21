package controllers

import play.api.mvc._
import com.codahale.jerkson.Json._
import models._
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def funds = Action {
    
    /*
    val funds = OldFund.findAll;
    val json = generate(funds);
     */
    val json = inTransaction {
        val fundata = from(TrackerSchema.funds)(s => 
          select(s)
        )
        generate(fundata);
    }
    

    Ok(json).as(JSON);
  }
  
  def inflation = Action {
    
    /*
    val s = inTransaction {
    	val inflation = new Inflation(2L, "EUR", 2013, 2L);
    	val result = TrackerSchema.inflations insert inflation;
    	generate(result);
    }
   */

    val json = inTransaction {
        val infData = from(TrackerSchema.inflations)(s => 
          select(s)
        )
        generate(infData);
    }
    
     
    Ok(json).as(JSON);
    
  }
  
  def generateFunds = Action {
    val json = inTransaction {
    	//val fundFall = new Fund(1L, "HU123", "Highest Fall Ever", "USD")
    	val fundMagic = new Fund(2L, "HU99999", "Magical Gain Ltd.", "EUR")
    	//TrackerSchema.funds insert fundFall;
    	val result = TrackerSchema.funds insert fundMagic;
    	generate(result);
    }
    Ok(json).as(JSON);

  }

}