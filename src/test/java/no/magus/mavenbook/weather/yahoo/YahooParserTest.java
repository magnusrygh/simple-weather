package no.magus.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.apache.log4j.Logger;

import junit.framework.TestCase;
import no.magus.mavenbook.weather.Weather;
import no.magus.mavenbook.weather.YahooParser;
//import no.magus.mavenbook.weather.YahooRetriever;

public class YahooParserTest extends TestCase {

    private static Logger log = Logger.getLogger(YahooParserTest.class);

	public YahooParserTest(String name) {
        super(name);
    }
    
    public void testParser() throws Exception {
    	log.info("testing Parser");
    	
        InputStream nyData = getClass().getClassLoader()
          .getResourceAsStream("testvarsel.xml");
      //  log.info(nyData.toString());
        Weather weather = new YahooParser().parse( nyData );
        assertEquals( "0791 Oslo", weather.getCity() );
        assertEquals( "Tryvannshøgda", weather.getRegion() );
        assertEquals( "Norge", weather.getCountry() );
        assertEquals( "7.9", weather.getTemp() );
        assertEquals( "Svak vind", weather.getWindspeed() );
    }
}
