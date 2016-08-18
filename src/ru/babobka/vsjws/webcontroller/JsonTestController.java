package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class JsonTestController extends WebController {

	private static final String JSON_RESPONSE = "{\n"
			+ "    \"glossary\": {\n"
			+ "        \"title\": \"example glossary\",\n"
			+ "\t\t\"GlossDiv\": {\n"
			+ "            \"title\": \"S\",\n"
			+ "\t\t\t\"GlossList\": {\n"
			+ "                \"GlossEntry\": {\n"
			+ "                    \"ID\": \"SGML\",\n"
			+ "\t\t\t\t\t\"SortAs\": \"SGML\",\n"
			+ "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n"
			+ "\t\t\t\t\t\"Acronym\": \"SGML\",\n"
			+ "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n"
			+ "\t\t\t\t\t\"GlossDef\": {\n"
			+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n"
			+ "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n"
			+ "                    },\n"
			+ "\t\t\t\t\t\"GlossSee\": \"markup\"\n" + "                }\n"
			+ "            }\n" + "        }\n" + "    }\n" + "}";

	@Override
	public HttpResponse onGet(HttpRequest request) {

		return HttpResponse.textResponse(JSON_RESPONSE,ContentType.JSON);
	}
}
