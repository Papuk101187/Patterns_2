package org.example.projecthttp.pattern.facade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projecthttp.details.Contact;
import org.example.projecthttp.details.ContactsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonHttpFacade {

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();
    private String token;


    public <T> T get(String url, Class<T> responseClass) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer ")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return (T) objectMapper.readValue(response.body(), responseClass);
    }

    public <T> T getAuthorized(String url, Class<T> responseClass, String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return (T) objectMapper.readValue(response.body(), responseClass);
    }

    public <T> T post(String url, Object object, Class<T> responseClass) throws IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(object);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        T respon = (T) objectMapper.readValue(response.body(), responseClass);
        return respon;
    }

    public <T> T postAuthorized(String uri, Object object, Class<T> responseClass, String token) throws IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(object);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responce = response.body();
        T respon = (T) objectMapper.readValue(response.body(), responseClass);
        return respon;
    }






}
