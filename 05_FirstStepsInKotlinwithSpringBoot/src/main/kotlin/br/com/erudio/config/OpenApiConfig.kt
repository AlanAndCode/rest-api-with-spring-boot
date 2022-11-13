package br.com.erudio.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    fun custonOpenApi(): OpenAPI {
        return OpenAPI()
         .info(
             Info()
                 .title("Test Swagger API, KOTLIN VERSION 1.7.10")
                 .version("v1")
                 .description("person Api")
             .termsOfService("https://github.com/AlanAndCode/rest-with-spring-boot-and-kotlin-erudio-Metodo-Get-")
                 .license(
                     License().name("Apache 2.0")
                         .url("https://github.com/AlanAndCode/rest-with-spring-boot-and-kotlin-erudio-Metodo-Get-")
                 )



         )
    }
}