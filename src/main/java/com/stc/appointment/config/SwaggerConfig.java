package com.stc.appointment.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	  public OpenAPI openAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Appointment Management")
	              .description("Appointment Management application")
	              .version("1.0.0")
	              .license(new License().name("stc 1.0")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Appointment Management System"));
	  }

}