package ru.babobka.vsjws.webcontroller;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;

public class XsltTestController extends WebController {

	private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <turtles> <turtle> <name>Leonardo</name> <weapon>Katana</weapon> </turtle> <turtle> <name>Raphael</name> <weapon>Sai</weapon> </turtle> <turtle> <name>Donatello</name> <weapon>Bō</weapon> </turtle> <turtle> <name>Michelangelo</name> <weapon>Nunchucks</weapon> </turtle> </turtles>";

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException,
			TransformerException {
		StringReader reader = null;
		StringWriter writer = null;
		try {
			reader = new StringReader(XML);
			writer = new StringWriter();
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory
					.newTransformer(new StreamSource("web-content/xslExample.xsl"));
			transformer.transform(new StreamSource(reader), new StreamResult(
					writer));
			String html = writer.toString();
			return HttpResponse.textResponse(html,ContentType.HTML);
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

}
