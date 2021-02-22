package org.example.projecthttp.pattern.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projecthttp.details.Contact;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonHttpFacade {

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();
    private String token;

    public <T> T post(String uri, Object body, Class<T> responseClass) throws IOException, InterruptedException {
        String uze = objectMapper.writeValueAsString(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(uze))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responce = response.body();
        T respon = (T) objectMapper.readValue(response.body(), responseClass);
        return respon;
    }

    public <T> T get(String url, Class<T> responseClass, String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return (T) objectMapper.readValue(response.body(), responseClass);
    }
}
