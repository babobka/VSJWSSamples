package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.runnable.WebController;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class XmlTestController extends WebController {

	private static final String XML_RESPONSE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<note>\n"
			+ "\t<to>Tove</to>\n" + "\t<from>Jani</from>\n" + "\t<heading>Reminder</heading>\n"
			+ "\t<body>Don't forget me this weekend!</body>\n" + "</note>";

	@Override
	public HttpResponse onGet(HttpRequest request) {

		return HttpResponse.xmlResponse(XML_RESPONSE);

	}

}
