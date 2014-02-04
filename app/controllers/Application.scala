package controllers

import play.api.mvc._
import com.codahale.jerkson.Json._
import models._
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import dtos._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def funds = Action {
    
    val json = inTransaction {
      
    	val fundata = 
    		from(TrackerSchema.funds, TrackerSchema.investors, TrackerSchema.investments, TrackerSchema.rates)(
    			(fund, investor, investment, rate) => 
    		where(fund.id === investment.fundId and investor.id === investment.investorId and fund.id === rate.fundId)
            select(fund.name, investor.name, investment.quantity, investment.buyinRate, rate.price, fund.currency)
        )
        
        var investments = collection.mutable.Set[InvestmentDto]();
        fundata.foreach(investment => (
        		investments add new InvestmentDto(
        		    investment._1, 
        		    investment._2,
        		    investment._3 * investment._5, 
        		    investment._4,
        		    investment._3 * investment._5, 
        		    investment._6,
        		    1,
        		    1
        		)
        	)
        );
        generate(investments);
    }
    Ok(json).as(JSON);
  }
  
  def inflation = Action {

    val json = inTransaction {
        val infData = from(TrackerSchema.inflations)(s => 
          select(s)
        )
        generate(infData);
    }
    
     
    Ok(json).as(JSON);
    
  }
  
  def generateFunds = Action {

	    	//fundMagic.investment.associate(magicInvestment);

	    val InvestmentJson = inTransaction {
	      
	    	val dummyId: Long = 0L;
      
    		val today = new java.util.Date;
    		
    		TrackerSchema.inflations insert new Inflation(dummyId, "HUF", 2013, 0.03F);
    		
    		val investor = TrackerSchema.investors insert new Investor(dummyId, "Brokker", 100L, "YEAR");
    		
    		val fundFall = TrackerSchema.funds insert new Fund(dummyId, "HU123", "Highest Fall Ever", "USD");
    		val fundMagic = TrackerSchema.funds insert new Fund(dummyId, "HU99999", "Magical Gain Ltd.", "EUR");
    		
    		TrackerSchema.rates insert new Rate(dummyId, fundFall.id, today, 100F);
    		TrackerSchema.rates insert new Rate(dummyId, fundMagic.id, today, 200F);
    		
	    	val fallInvestment = new Investment(dummyId, "John Dow", fundFall.id, investor.id, today, 0.015F, 15F);
	    	val magicInvestment = new Investment(dummyId, "John Dow", fundMagic.id, investor.id, today, 0.015F, 13F);
	    	
	    	TrackerSchema.investments insert magicInvestment;
	    	val result = TrackerSchema.investments insert fallInvestment;

	    	generate(result);
	    }
	      
	    Ok(InvestmentJson).as(JSON);
  }
  


}