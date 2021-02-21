package org.example.projecthttp.pattern.facade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projecthttp.details.TokenResponse;
import org.example.projecthttp.details.User;
import org.example.projecthttp.pattern.facade.dto.StatusResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonHttpFacade {

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();
    private String token;


    public TokenResponse authorization(String url,User user) throws IOException, InterruptedException {

        String uze = objectMapper.writeValueAsString(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(uze))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responce = response.body();
        TokenResponse tokenResponse = objectMapper.readValue(responce, TokenResponse.class);
        return tokenResponse;
    }

    public ContactsResponse get(String url, String token) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ContactsResponse contactsResponse = objectMapper.readValue(response.body(), ContactsResponse.class);
        return contactsResponse;
    }


    public StatusResponse add(String url, Contact contact, String token) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String ond = objectMapper.writeValueAsString(contact);
        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(ond))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        StatusResponse statusResponse = objectMapper.readValue(response.body(), StatusResponse.class);
        return statusResponse;
    }
}
