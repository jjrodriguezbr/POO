package com.example.tutoria03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Estudiantes - Grupo 01")
                .version("1.0.0")
                .description("API REST para gestión de estudiantes - Tutorías APOO")
                .contact(new Contact()
                    .name("Grupo 01")
                    .email("grupo01@yopmail.com")));
    }
}
