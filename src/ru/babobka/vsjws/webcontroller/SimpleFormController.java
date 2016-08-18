package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.model.HttpResponse.ResponseCode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class SimpleFormController extends WebController {

	private static final String SUCCESS_RESPONSE = "Success!";

	private static final String EMPTY_FIELDS_RESPONSE = "All fields should be filled.";

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException,
			URISyntaxException {
		return HttpResponse
				.fileResponse(new File("web-content/simpleForm.html"));
	}

	@Override
	public HttpResponse onPost(HttpRequest request) {
		if (request.getParam("first_name") != null
				&& request.getParam("second_name") != null
				&& request.getParam("password") != null) {
			return HttpResponse.textResponse(SUCCESS_RESPONSE,
					ContentType.PLAIN);
		} else {
			return HttpResponse.textResponse(EMPTY_FIELDS_RESPONSE,
					ResponseCode.BAD_REQUEST, ContentType.PLAIN);
		}
	}
}
