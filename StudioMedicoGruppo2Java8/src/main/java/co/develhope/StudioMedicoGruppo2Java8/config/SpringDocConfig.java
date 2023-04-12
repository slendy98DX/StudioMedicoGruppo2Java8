package co.develhope.StudioMedicoGruppo2Java8.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info =
        @Info(title = "Healthcare.com", version = "1.0", description = "Progetto finale"),
        tags = {@Tag(name = "doctor-controller", description = "The doctor controller that contains all CRUD methods" +
                " for the Doctor entity"),
                @Tag(name = "patient-controller", description = "The patient controller that contains all CRUD methods" +
                " for the Patient entity"),
                @Tag(name = "secretary-controller", description = "The secretary controller that contains all CRUD methods" +
                        " for the Secretary entity"),
                @Tag(name = "booking-controller", description = "The booking controller that contains all CRUD methods" +
                        " for the Booking entity")}
        )
@Configuration
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/public/**")
                .build();
    }

    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
