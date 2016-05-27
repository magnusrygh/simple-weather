package no.magus.mavenbook.weather;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.log4j.Logger;

public class YahooRetriever {
    private static Logger log = Logger.getLogger(YahooRetriever.class);
    
    public InputStream retrieve(String zipcode) throws Exception {
        log.info( "Retrieving Weather Data" );
        String url = "http://www.yr.no/sted/Norge/postnummer/0791/varsel.xml";
//          + zipcode;
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
