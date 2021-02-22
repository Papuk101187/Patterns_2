package org.example.projecthttp.service;

import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projecthttp.details.TokenResponse;
import org.example.projecthttp.details.User;
import org.example.projecthttp.pattern.facade.JsonHttpFacade;
import org.example.projecthttp.pattern.facade.dto.StatusResponse;

import java.io.IOException;
import java.util.Arrays;


public class ConactApiService implements ApiService {

    TokenResponse tokenResponse;
    User user; ///user
    JsonHttpFacade jsonHttpFacade = new JsonHttpFacade(); //My facade

    public ConactApiService(User user) {
        this.user = user;
    }


    @Override
    public void get() throws IOException, InterruptedException {

        ContactsResponse contactsResponse =
                jsonHttpFacade
                        .get("https://mag-contacts-api.herokuapp.com/users", ContactsResponse.class);

        System.out.println("ContactsResponse  "+contactsResponse.getUsers());

    }

    @Override
    public void post(User user) throws IOException, InterruptedException {

        tokenResponse = jsonHttpFacade
                .post("https://mag-contacts-api.herokuapp.com/login"
                        , user,
                        TokenResponse.class);
    }

}
