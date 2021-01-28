package com.example.todo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()).info(getApiInfo());
    }

    private Info getApiInfo() {
        return new Info().title("TODOs API").description("REST API to handle todos.").version("1.0")
                .contact(null);
    }
}