package no.magus.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
//import com.google.common.io.CharStreams;
//import java.io.InputStreamReader;
import org.apache.log4j.Logger;

import no.magus.mavenbook.weather.Weather;
import no.magus.mavenbook.weather.WeatherFormatter;
import no.magus.mavenbook.weather.YahooParser;

import junit.framework.TestCase;

public class WeatherFormatterTest extends TestCase {
    private static Logger log = Logger.getLogger(WeatherFormatterTest.class);

	  public WeatherFormatterTest(String name) {
		    super(name);
		}
		  public void testFormat() throws Exception {
			  log.info("Testing WeatherFormatter");
		    InputStream nyData = getClass().getClassLoader()
		      .getResourceAsStream("testvarsel.xml");
		    Weather weather = new YahooParser().parse( nyData );
		    String formattedResult = new WeatherFormatter().format( weather );
		    InputStream expected = getClass().getClassLoader()
		      .getResourceAsStream("format-expected.dat");
//		    assertEquals( CharStreams.toString( new InputStreamReader(expected, "UTF-8") ).trim(),
//		    		formattedResult.trim() );
		    assertEquals( IOUtils.toString( expected ).trim(),
    		formattedResult.trim() );
		}
		  
}
