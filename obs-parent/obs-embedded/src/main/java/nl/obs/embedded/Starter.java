package nl.obs.embedded;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {
	private final static Logger logger = LoggerFactory.getLogger(Starter.class);
	
	private final static String LOCATION = "/war/obs-web-0.1.0-SNAPSHOT.war";
	
	
	public static void main(String[] args) throws Exception {
        
        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPortStr = System.getenv("PORT");
        int webPort = (webPortStr != null && !webPortStr.isEmpty()) ? Integer.parseInt(webPortStr) : 8080;
        
        String baseDir = System.getProperty("app.base.dir");  
        if(baseDir == null || baseDir.isEmpty()) {
        	throw new IllegalArgumentException("the property \"app.base.dir\" is not set. Make sure to set it using -Dapp.base.dir=<BASEDIR> .");
        }
        
        TomcatWrapper tomcat = new TomcatWrapper(webPort, baseDir+"/war/", System.getProperty("java.io.tmpdir"));        
        tomcat.addWebApp("/", new File(baseDir+LOCATION).getAbsolutePath());
        
        logger.info("configuring app with basedir: {}" , new File(baseDir+LOCATION).getAbsolutePath());
        
        tomcat.start();        
    }
}
