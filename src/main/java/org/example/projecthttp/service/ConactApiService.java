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
    public void add(Contact contact) throws IOException, InterruptedException {


        System.out.println(tokenResponse.getToken());


        StatusResponse statusResponse = (StatusResponse) jsonHttpFacade
                .add("https://mag-contacts-api.herokuapp.com/contacts/add",
                        StatusResponse.class,
                        tokenResponse.getToken(),contact);
    }

    @Override
    public void get() throws IOException, InterruptedException {
        {
            System.out.println("ConactApiService.get");
        }
        ContactsResponse contactsResponse = (ContactsResponse)
                jsonHttpFacade
                        .get("https://mag-contacts-api.herokuapp.com/contacts",
                                ContactsResponse.class,
                                tokenResponse.getToken());

        System.out.println(Arrays.toString(contactsResponse.getContacts())); //для наглядности
    }

    @Override
    public void authorization(User user) throws IOException, InterruptedException {

        tokenResponse = (TokenResponse) jsonHttpFacade
                .post("https://mag-contacts-api.herokuapp.com/login"
                        , user,
                        TokenResponse.class);
    }


}
