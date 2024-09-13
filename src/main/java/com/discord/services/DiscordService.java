package com.discord.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class DiscordService {
    public void sendMessage(Object data) throws IOException, InterruptedException {
        var urlWebhook = "https://discord.com/api/webhooks/1267133591599710229/Dr1Y6mZ4Zkw22JhD_AIgzCq1gf2-GDGrxD92XwQyrAnRwxXdzU0BOVMLJbQXCTzsmTAJ";

        //1 - json
        var json = new ObjectMapper().writeValueAsString(data);

        //2 - abrir conexao com cliente
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(urlWebhook))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        //3 - exibir status
        var response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("resposta: " + response.body());
    }
}
