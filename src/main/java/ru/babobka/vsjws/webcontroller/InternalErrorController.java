package ru.babobka.vsjws.webcontroller;

import ru.babobka.vsjws.model.HttpRequest;
import ru.babobka.vsjws.model.HttpResponse;

/**
 * Created by dolgopolov.a on 30.12.15.
 */
public class InternalErrorController extends WebController {


    @Override
    public HttpResponse onGet(HttpRequest request) {
        throw new NullPointerException();
    }
    
}
