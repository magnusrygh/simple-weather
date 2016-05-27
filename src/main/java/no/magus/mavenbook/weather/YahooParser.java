package no.magus.mavenbook.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {
	  private static Logger log = Logger.getLogger(YahooParser.class);
	  public Weather parse(InputStream inputStream) throws Exception {
	    Weather weather = new Weather();
	    log.info( "Creating XML Reader" );
	    SAXReader xmlReader = createXmlReader();
	    Document doc = xmlReader.read( inputStream );
	    log.info( "Parsing XML Response" );
	    weather.setCity(
	      doc.valueOf("/weatherdata/location/name") );
	    weather.setRegion(
	      doc.valueOf("/weatherdata/observations/weatherstation[1]/@name") );
	    weather.setCountry(
	      doc.valueOf("/weatherdata/location/country") );
	    weather.setWindspeed(
	      doc.valueOf("/weatherdata/observations/weatherstation[@stno='18950']/windSpeed/@name") );
	    weather.setTemp(
	      doc.valueOf("/weatherdata/observations/weatherstation[1]/temperature/@value") );

	    return weather;
	  }
	  private SAXReader createXmlReader() {
	    Map<String,String> uris = new HashMap<String,String>();
	    uris.put( "y", "http://xml.weather.yahoo.com/ns/rss/1.0" );
	    DocumentFactory factory = new DocumentFactory();
	        factory.setXPathNamespaceURIs( uris );
	    SAXReader xmlReader = new SAXReader();
	      xmlReader.setDocumentFactory( factory );
	    return xmlReader;
	  }
}
