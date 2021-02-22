package org.example.projecthttp.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projecthttp.details.TokenResponse;
import org.example.projecthttp.details.User;
import org.example.projecthttp.pattern.facade.JsonHttpFacade;
import org.example.projecthttp.pattern.facade.JsonHttpFacadeTEST;
import org.example.projecthttp.pattern.facade.dto.StatusResponse;

import java.io.IOException;


public class ConactApiService implements ApiService {

    TokenResponse tokenResponse; //token
    User user; ///user

    JsonHttpFacade jsonHttpFacade = new JsonHttpFacade(); //My facade
    JsonHttpFacadeTEST jsonHttpFacadeTEST = new JsonHttpFacadeTEST();

    public ConactApiService(User user) {
        this.user = user;
    }


    @Override
    public StatusResponse add(Contact contact) throws IOException, InterruptedException {
        StatusResponse statusResponse = jsonHttpFacade
                .add("https://mag-contacts-api.herokuapp.com/contacts/add", contact, tokenResponse.getToken());
        return statusResponse;
    }

    @Override
    public ContactsResponse get() throws IOException, InterruptedException {
        ContactsResponse statusResponse = jsonHttpFacade.get("https://mag-contacts-api.herokuapp.com/contacts",tokenResponse.getToken());
        return statusResponse;
    }


    @Override
    public void authorization(User user) throws IOException, InterruptedException {

        tokenResponse = jsonHttpFacade.authorization("https://mag-contacts-api.herokuapp.com/login", user);

    }
}
