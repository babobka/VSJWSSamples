package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.model.HttpResponse.ResponseCode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class CookieTestController extends WebController {

	private static final String EMPTY_FIELDS_RESPONSE = "All fields should be filled.";

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException,
			URISyntaxException {
		String action = request.getUrlParam("action");
		if (action != null && action.equals("list")) {
			return HttpResponse.textResponse(request.getCookies().toString(),
					ContentType.PLAIN);
		} else {
			return HttpResponse.fileResponse(new File(
					"web-content/cookies.html"));
		}
	}

	@Override
	public HttpResponse onPost(HttpRequest request) {
		String key = request.getParam("key"), value = request.getParam("value");
		if (key != null && value != null) {
			HashMap<String, String> cookieMap = new HashMap<>();
			cookieMap.putAll(request.getCookies());
			cookieMap.put(key, value);
			HttpResponse httpResponse = HttpResponse.textResponse(
					cookieMap.toString(), ContentType.PLAIN);
			httpResponse.addCookie(key, value);
			return httpResponse;
		} else {
			return HttpResponse.textResponse(EMPTY_FIELDS_RESPONSE,
					ResponseCode.BAD_REQUEST, ContentType.PLAIN);
		}
	}
}
