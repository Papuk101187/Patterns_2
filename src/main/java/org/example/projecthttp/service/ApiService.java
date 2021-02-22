package org.example.projecthttp.service;

import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projecthttp.details.User;
import org.example.projecthttp.pattern.facade.dto.StatusResponse;

import java.io.IOException;

public interface ApiService {





    public void get() throws IOException, InterruptedException;
    public void getAuthorized() throws IOException, InterruptedException;
    void post(User user) throws IOException, InterruptedException;
    void postAuthorized(Contact contact) throws IOException, InterruptedException;



}
