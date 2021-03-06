package ru.babobka.vsjws;

import java.io.IOException;

import ru.babobka.vsjws.webserver.WebServer;
import ru.babobka.vsjws.webcontroller.CookieTestController;
import ru.babobka.vsjws.webcontroller.HeavyRequestController;
import ru.babobka.vsjws.webcontroller.InternalErrorController;
import ru.babobka.vsjws.webcontroller.JsonTestController;
import ru.babobka.vsjws.webcontroller.MainPageController;
import ru.babobka.vsjws.webcontroller.RedirectTestController;
import ru.babobka.vsjws.webcontroller.SessionTestController;
import ru.babobka.vsjws.webcontroller.SimpleFormController;
import ru.babobka.vsjws.webcontroller.XmlTestController;
import ru.babobka.vsjws.webcontroller.XsltTestController;

public class Main {

	private static final int PORT = 2512;

	private static final int SESSION_TIMEOUT_SECS = 15 * 60;

	private static final String SERVER_NAME = "Sample server";

	private static final String LOG_FOLDER = "server_log";

	private static final boolean DEBUG_MODE = true;

	public static void main(String[] args) throws IOException {

		WebServer webServer = new WebServer(SERVER_NAME, PORT, SESSION_TIMEOUT_SECS, LOG_FOLDER, DEBUG_MODE);
		// Adding controllers for a specified URLs
		webServer.addController("json", new JsonTestController());
		webServer.addController("xml", new XmlTestController());
		webServer.addController("heavy", new HeavyRequestController());
		webServer.addController("error", new InternalErrorController());
		webServer.addController("session", new SessionTestController());
		webServer.addController("simpleForm", new SimpleFormController());
		webServer.addController("xslt", new XsltTestController());
		webServer.addController("cookies", new CookieTestController());
		webServer.addController("redirect", new RedirectTestController());
		webServer.addController("", new MainPageController());
		webServer.start();
		

	}

}
