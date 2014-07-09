package com.infinityappsolutions.server.webdesigner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import com.infinityappsolutions.server.IASServer;

public class WebDesignerMain {

	public static void main(String[] args) throws Exception {
		IASServer iasServer = new IASServer();
		iasServer.loadSystemProperties();
		ContextHandlerCollection contexts = iasServer.configure();
		iasServer.fullWebAppDeployment(contexts);
		iasServer.start();
		iasServer.join(); 
	}

	public static void testProperties() throws IOException {
		FileInputStream propFile = new FileInputStream("config.properties");
		Properties p = new Properties(System.getProperties());
		p.load(propFile);
		System.out.println(p.get("user.dir"));

		System.out.println();
	}

	public void test() throws Exception {

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/webdesigner");
		webapp.setWar("/home/jchardis/git/InfinityAppSolutions-WebApps/WebDesigner");
		IASServer iasServer = new IASServer();
		iasServer.loadSystemProperties();
		iasServer.configure();
		iasServer.setWebAppContext(webapp);
		// iasServer.setLoginService(webapp);
		iasServer.start();
		iasServer.join();
	}
}
