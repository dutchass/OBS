package nl.obs.embedded;

import java.io.File;

import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {
	private final static Logger logger = LoggerFactory.getLogger(Starter.class);
	
	private final static String LOCATION = "C:\\Users\\bas\\workspace3\\OBS\\obs-parent\\obs-embedded\\target\\dependency\\obs-web-0.1.0-SNAPSHOT.war";

	public static void main(String[] args) throws Exception {

		for (String string : args) {
			logger.info("arg: "+ string);
		}
        
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));
        
        StandardHost stdHost = (StandardHost) tomcat.getHost();
        stdHost.setUnpackWARs(false); 
        stdHost.setAutoDeploy(true); 
        stdHost.setDeployOnStartup(true); 

        tomcat.setHost(stdHost); 

        tomcat.addWebapp("/", new File(LOCATION).getAbsolutePath());
        logger.info("configuring app with basedir: {}" , new File(LOCATION).getAbsolutePath());
        
        

        tomcat.start();
        tomcat.getServer().await();  
    }

}
