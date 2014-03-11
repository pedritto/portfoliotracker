package data

import play.api.Play;
import play.api.Play.current;
import scala.io.Source;

object CsvReader {
  
  def readLines(fileName: String) : List[String] = {
    val fileStream = Play.classloader.getResourceAsStream(fileName);
    Source.fromInputStream(fileStream).getLines().toList;
  }

}