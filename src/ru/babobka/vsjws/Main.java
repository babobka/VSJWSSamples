package ru.babobka.vsjws;

import java.io.IOException;

import ru.babobka.vsjws.model.WebServer;
import ru.babobka.vsjws.webcontroller.CookieTestController;
import ru.babobka.vsjws.webcontroller.EncodingTestController;
import ru.babobka.vsjws.webcontroller.HeavyRequestController;
import ru.babobka.vsjws.webcontroller.InternalErrorController;
import ru.babobka.vsjws.webcontroller.JsonTestController;
import ru.babobka.vsjws.webcontroller.MainPageController;
import ru.babobka.vsjws.webcontroller.SessionTestController;
import ru.babobka.vsjws.webcontroller.SimpleFormController;
import ru.babobka.vsjws.webcontroller.XmlTestController;
import ru.babobka.vsjws.webcontroller.XsltTestController;

public class Main {

	private static final int PORT = 2512;

	private static final int SESSION_TIMEOUT_SECS = 15 * 60;

	public static final String WEB_CONTENT_FOLDER = "web-content";

	public static void main(String[] args) throws IOException
			 {
		WebServer webServer = new WebServer("rest server", PORT, false,
				SESSION_TIMEOUT_SECS, WEB_CONTENT_FOLDER, "rest_log", null);	
		//Adding controllers for a specified URLs			
		webServer.addController("/json", new JsonTestController());
		webServer.addController("/xml", new XmlTestController());
		webServer.addController("/encoding", new EncodingTestController());
		webServer.addController("/heavy", new HeavyRequestController());
		webServer.addController("/error", new InternalErrorController());
		webServer.addController("/session", new SessionTestController());
		webServer.addController("/simpleForm", new SimpleFormController());
		webServer.addController("/xslt", new XsltTestController());
		webServer.addController("/cookies", new CookieTestController());
		webServer.addController("/", new MainPageController());
		webServer.run();
	}

}
