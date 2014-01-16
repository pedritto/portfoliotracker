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
    
    val funds = Fund.findAll;
    val json = generate(funds);
    Ok(json).as(JSON);
  }
  
  def inflation = Action {
    
    /*
    val json = inTransaction {
    	val inflation = new Inflation(2L, "EUR", 2013, 2L);
    	val result = TrackerSchema.inflationTable insert inflation;
    	generate(result);
    }
*/    

    val json = inTransaction {
        val infData = from(TrackerSchema.inflationTable)(s => 
          select(s)
        )
        generate(infData);
    }
    
     
    Ok(json).as(JSON);
    
  }

}