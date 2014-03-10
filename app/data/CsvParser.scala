package data

import models.Rate;
import play.api.Play;
import play.api.Play.current;
import scala.io.Source;
import java.util.Date;

object CsvParser {
  
  val dummyId = 0L;
  
  def read(fundId: Long, fileName: String, separator: String) : List[Rate] = {
    
    val fileStream = Play.classloader.getResourceAsStream(fileName);
    
    val rates = Source.fromInputStream(fileStream) getLines() map (l => readLine(l, fundId, separator));
    
    return rates.toList;
  }
  
  def readLine(line: String, fundId: Long, separator: String) : Rate = {
    val data = line.split(separator);
    val date = new Date(data(0));
    val value = data(2).toFloat;
    return new Rate(dummyId, fundId, date, value);
  }

}