import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
public class Log4jExample
{
    static Logger log = Logger.getLogger(Log4jExample.class);
 
    public static void main(String[] args)
    {
        PropertyConfigurator.configure("log4j.html");
 
        log.debug("Sample debug message");
        log.info("Sample info message");
        log.error("Sample error message");
        log.fatal("Sample fatal message");
    }
}