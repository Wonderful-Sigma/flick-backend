package sigma.dauth;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.DAuthBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class DAuthConfig {

    private final DAuthProperties properties;

    @Bean
    public DAuth dauth() {
        return DAuthBuilder.create()
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .build();
    }

}