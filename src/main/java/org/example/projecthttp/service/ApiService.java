package org.example.projecthttp.service;

import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projecthttp.details.User;
import org.example.projecthttp.pattern.facade.dto.StatusResponse;

import java.io.IOException;

public interface ApiService {



    public StatusResponse add(Contact contact) throws IOException, InterruptedException;

    void authorization(User user) throws IOException, InterruptedException;

    public ContactsResponse get() throws IOException, InterruptedException;



}
