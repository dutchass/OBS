package nl.obs.embedded;

import java.io.File;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Constants;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TomcatWrapper {

	private final Tomcat tomcat;
	
	private final Logger log = LoggerFactory.getLogger(TomcatWrapper.class);

	public TomcatWrapper(int port, String baseDir, String workDir) {
		tomcat = new Tomcat();
		tomcat.enableNaming();
		tomcat.setBaseDir(baseDir);
		tomcat.setPort(port);
		

		StandardHost stdHost = (StandardHost) tomcat.getHost();
		stdHost.setUnpackWARs(true);
		stdHost.setAutoDeploy(true);
		stdHost.setDeployOnStartup(true);
		stdHost.setDeployXML(true);
		stdHost.setAppBase(baseDir);
		
		stdHost.setWorkDir(workDir);

		tomcat.setHost(stdHost);
		
	}
	
	public void start() throws LifecycleException {
		tomcat.start();
		tomcat.getServer().await();  
	}

	public void stop() throws LifecycleException {
		tomcat.stop();
	}

	public void destroy() throws LifecycleException {
		tomcat.destroy();
	}


	public Context addWebApp(String contextPath, String webappFilePath) {
		JarFile webappJarFile = null;
		JarEntry contextXmlFileEntry = null;
		Context ctx = null;
		try {
			ctx = new StandardContext();
			ctx.setName(contextPath);
			ctx.setPath(contextPath);
			ctx.setDocBase(webappFilePath);

			ctx.setRealm(tomcat.getHost().getRealm());

			ctx.addLifecycleListener(new Tomcat.DefaultWebXmlListener());

			ContextConfig ctxCfg = new ContextConfig();
			ctx.addLifecycleListener(ctxCfg);

			// prevent it from looking ( if it finds one - it'll have dup error
			// )
			ctxCfg.setDefaultWebXml("org/apache/catalin/startup/NO_DEFAULT_XML");

			File f = new File(webappFilePath);
			// During dir based webapp deployment
			if (f.isDirectory()) {
				File cf = new File(webappFilePath + File.separator
						+ Constants.ApplicationContextXml);
				if (cf.exists()) {
					ctx.setConfigFile(cf.toURI().toURL());
				}
			} else {
				// Check for embedded contextXml file in this webapp
				webappJarFile = new JarFile(webappFilePath);
				contextXmlFileEntry = webappJarFile
						.getJarEntry(Constants.ApplicationContextXml);
				if (contextXmlFileEntry != null) {
					ctx.setConfigFile(new URL("jar:file:" + webappFilePath
							+ "!/" + Constants.ApplicationContextXml));
				}
			}

			tomcat.getHost().addChild(ctx);
			if (ctx.getState().equals(LifecycleState.STOPPED)) {
				ctx.setRealm(null);
				ctx.destroy();
				log.error("webApp" + ctx + "failed to deploy");
			}
			log.info("web application context: " + ctx);
		} catch (Exception e) {
			log.error("webApp failed to deploy", e);

		} finally {
			contextXmlFileEntry = null;
			if (webappJarFile != null) {
				try {
					webappJarFile.close();
				} catch (Throwable t) {
					ExceptionUtils.handleThrowable(t);
				}
				webappJarFile = null;
			}
		}
		return ctx;
	}
}
