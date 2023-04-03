package co.develhope.StudioMedicoGruppo2Java8.config;

import it.pasqualecavallo.studentsmaterial.authorization_framework.config.DefinitelyBasicAuthorizationFrameworkAutoconfiguration;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ExclusionPatterEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DefinitelyBasicAuthorizationFrameworkAutoconfiguration.class)
public class AuthorizationConfig {

    /**
     * Allow the global exclusion pattern to work.
     * If you don't need this behavior, feel free not to create this bean.
     *
     * @return
     * @see it.pasqualecavallo.studentsmaterial.authorization_framework.filter.DetectMethodHandlerFilter
     */
    @Bean
    public ExclusionPatterEvaluator exclusionPatterEvaluator() {
        return new ExclusionPatterEvaluator().mustExcludeAntPathMatchers("/swagger-ui", "/swagger-ui/**", "/v3", "/v3/**");
    }
}
