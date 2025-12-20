package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        Server amypoServer = new Server();
        amypoServer.setUrl("https://9426.pro604cr.amypo.ai/");
        amypoServer.setDescription("Amypo Preview Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Vendor SLA Performance Tracker API")
                        .description("API documentation for Vendor SLA Performance Tracker")
                        .version("1.0.0"))
                .addServersItem(amypoServer);
    }
}
