package org.note.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "My Notes API",
                version = "1.0",
                description = "This API allows you to manage notes.",
                contact = @Contact(
                        name = "Your Name",
                        email = "youremail@example.com",
                        url = "https://www.yourwebsite.com"
                ),
                termsOfService = "https://www.yourwebsite.com/terms",
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)
public class SwaggerConfig {
}
