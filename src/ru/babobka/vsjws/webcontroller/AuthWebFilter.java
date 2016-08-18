package ru.babobka.vsjws.webcontroller;



import ru.babobka.vsjws.constant.ContentType;
import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;
import ru.babobka.vsjws.model.HttpResponse.ResponseCode;

public class AuthWebFilter implements WebFilter {

	private static final String LOGIN = "user";

	private static final String PASSWORD = "123";


	@Override
	public void afterFilter(HttpRequest request, HttpResponse response) {		
		//Do nothing
	}

	@Override
	public HttpResponse onFilter(HttpRequest request) {
		String login = request.getHeader("X-Login");
		String password = request.getHeader("X-Password");		
		if ((login == null || password == null)
				|| (!login.equals(LOGIN) || !password.equals(PASSWORD))) {
			// Show error response
			return HttpResponse.textResponse("Bad login/password combination",
					ResponseCode.UNAUTHORIZED,
					ContentType.PLAIN);
		} else {
			//Do nothing. Proceed.
			return null;
		}
	}

}
