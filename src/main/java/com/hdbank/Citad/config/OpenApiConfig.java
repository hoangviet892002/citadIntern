package com.hdbank.Citad.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Citad API", version = "1.0", description = "Documentation Citad API v1.0"))
@SecurityScheme(
        name = "Api-Key",
        description = "API Key Authentication",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER
)
@Configuration
public class OpenApiConfig {
}
