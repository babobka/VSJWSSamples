package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;

public class RedirectTestController extends WebController {

	public HttpResponse onGet(HttpRequest request) {
		return HttpResponse.redirectResponse("http://google.com");
	}
}
