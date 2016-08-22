package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.model.HttpResponse.ResponseCode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by dolgopolov.a on 12.01.16.
 */
public class SessionTestController extends WebController {

	private static final String EMPTY_FIELDS_RESPONSE = "All fields should be filled.";

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException,
			URISyntaxException {
		String action = request.getUrlParam("action");
		if (action.equals("list")) {
			return HttpResponse.textResponse(request.getSession().toString(),
					ContentType.PLAIN);
		} else {
			return HttpResponse.fileResponse(new File(
					"web-content/session.html"));
		}

	}

	@Override
	public HttpResponse onPost(HttpRequest request) {
		String key = request.getParam("key"), value = request.getParam("value");
		if (!key.isEmpty() && !value.isEmpty()) {
			request.getSession().put(key, value);
			return HttpResponse.textResponse(request.getSession().toString(),
					ContentType.PLAIN);

		} else {
			return HttpResponse.textResponse(EMPTY_FIELDS_RESPONSE,
					ResponseCode.BAD_REQUEST, ContentType.PLAIN);
		}
	}

}
