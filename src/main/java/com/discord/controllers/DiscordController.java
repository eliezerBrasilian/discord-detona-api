package com.discord.controllers;

import com.discord.services.DiscordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/v1/meu-discord")
@RestController
public class DiscordController{

    @Autowired
    DiscordService discordService;

    @Operation(summary = "Realiza o envio de uma mensagem personalizada em nosso servidor Dev Detona no Discord",
            method = "POST")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envio realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao tentar realizar o envio"),
    })
    @PostMapping
    void sendMessage(@RequestBody Object data) throws IOException, InterruptedException {
        discordService.sendMessage(data);
    }
}