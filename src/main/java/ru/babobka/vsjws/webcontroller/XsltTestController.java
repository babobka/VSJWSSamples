package ru.babobka.vsjws.webcontroller;

import java.io.IOException;


import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.runnable.WebController;

public class XsltTestController extends WebController {

	private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <turtles> <turtle> <name>Leonardo</name> <weapon>Katana</weapon> </turtle> <turtle> <name>Raphael</name> <weapon>Sai</weapon> </turtle> <turtle> <name>Donatello</name> <weapon>Bō</weapon> </turtle> <turtle> <name>Michelangelo</name> <weapon>Nunchucks</weapon> </turtle> </turtles>";

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException {

		return HttpResponse.xsltResponse(XML, "web-content/xslExample.xsl");
	}

}
