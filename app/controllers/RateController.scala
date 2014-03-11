package controllers

import play.api.mvc._
import com.codahale.jerkson.Json._

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

import data._
import models._

object RateController extends Controller {
  
  val FILE_NAME = "sampleRates.csv";
  val SEPARATOR = ",";
    
  // TODO: to be deleted. Just to test the file reading. 
  def loadRates(fundId: Long) = Action {
	  Ok(
	      generate(
	          CsvReader
	          	.readLines(FILE_NAME)
	          	.map(
	          	    line => RateParser.parse(line, SEPARATOR, fundId)
	          	 )
	      )
	  ).as(JSON);
  }
  
  // TODO: check if rate exists
  def saveRates(fundId: Long) = Action {
    
	CsvReader.readLines(FILE_NAME)
    		 .map(
    		     line => RateParser.parse(line, SEPARATOR, fundId)
    		 )
    		 .foreach(rate => 
    		 	inTransaction {
    		 		generate(TrackerSchema.rates insert rate);
				}
		     );
    Ok(views.html.index())
  }

}