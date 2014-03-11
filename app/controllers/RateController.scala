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
  
  // TODO: Persist rates
  def uploadRates(fundId: Long) = Action {
    
     val rates = inTransaction {
    	 CsvReader
    	 	.readLines(FILE_NAME)
    	 	.map(
    	 	    line => RateParser.parse(line, SEPARATOR, fundId)
    	 	);
     }
    
     Ok(views.html.index());
  }

}