package co.develhope.StudioMedicoGruppo2Java8.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info =
        @Info(title = "Studio Medico Gruppo 2 Java 8", version = "1.0", description = "Progetto finale"),
        tags = {@Tag(name = "doctor-controller", description = "The doctor controller that contains all CRUD methods" +
                " for the DoctorDTO class"),
                @Tag(name = "patient-controller", description = "The patient controller that contains all CRUD methods" +
                " for the PatientDTO class"),
                @Tag(name = "secretary-controller", description = "The secretary controller that contains all CRUD methods" +
                        " for the SecretaryDTO class")}
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
}
