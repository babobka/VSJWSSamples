package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;


public class HeavyRequestController extends WebController {

	private static final String MESSAGE = "Ok";

	@Override
	public HttpResponse onGet(HttpRequest request) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		return HttpResponse.textResponse(MESSAGE,ContentType.PLAIN);
	}
}