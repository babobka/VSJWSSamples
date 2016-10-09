package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;

import java.io.IOException;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class MainPageController extends WebController {

	@Override
	public HttpResponse onGet(HttpRequest request) throws IOException  {
		return HttpResponse.resourceResponse("web-content/main.html");

	}
}
