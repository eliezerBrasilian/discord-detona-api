package com.discord.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Value("${cors.originPatters}")
    private String originPatters;

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        var allowedOrigins = originPatters.split(",");

        corsRegistry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins(allowedOrigins)
                .allowCredentials(true);


    }

}
