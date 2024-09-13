package com.discord.controllers;

import com.discord.services.DiscordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequestMapping("api/v1/meu-discord")
@RestController
public class DiscordController{

    @Autowired
    DiscordService discordService;

    @PostMapping
    void sendMessage(@RequestBody Object data) throws IOException, InterruptedException {
        discordService.sendMessage(data);
    }
}