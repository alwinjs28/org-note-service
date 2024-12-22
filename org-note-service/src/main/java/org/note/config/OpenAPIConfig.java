package org.note.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Note API")
                        .description("This application allows users to perform basic CRUD (Create, Read, Update, Delete) operations on notes.")
                        .version("1.0.0"));
    }
}
