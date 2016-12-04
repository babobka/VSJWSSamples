package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.runnable.WebController;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class JsonTestController extends WebController {

	private static final String JSON_RESPONSE = "{\"id\": 1, \"name\": \"A green door\",  \"price\": 12.50, \"tags\": [\"home\", \"green\"]}";

	@Override
	public HttpResponse onGet(HttpRequest request) {

		return HttpResponse.jsonResponse(JSON_RESPONSE);
	}
}
