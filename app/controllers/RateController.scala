package controllers

import play.api.mvc._
import com.codahale.jerkson.Json._
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import data._
import models._

object RateController extends Controller {
  
  def loadRates(fundId: Long) = Action {
    	 
    val rateJson = inTransaction {
      val rates = CsvParser.read(fundId, "sampleRates.csv", ",");
      generate(rates);
	}
    
	Ok(rateJson).as(JSON);
  }

}