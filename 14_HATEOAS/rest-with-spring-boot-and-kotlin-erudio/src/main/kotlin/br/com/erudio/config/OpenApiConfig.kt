package br.com.erudio.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenApi(): OpenAPI{
        return OpenAPI().info(Info()
            .title("RESTFul API with Kotlin 1.6.10 and Spring Boot 3.0.0")
            .version("V1")
            .description("Description about API")
            .termsOfService("https://apicursokotlin.com.br/curso")
            .license(
                License().name("Apache 2.0")
                    .url("https://apicursokotlin.com.br")
            )
        )

    }
}