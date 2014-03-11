package data

import models.Rate;
import java.util.Date;

object RateParser {
  
	val dummyId = 0L;
  
    def parse(line: String, separator: String, fundId: Long) : Rate = {
	    val data = line.split(separator);
	    val date = new Date(data(0));
	    val value = data(1).toFloat;
	    return new Rate(dummyId, fundId, date, value);
    }

}