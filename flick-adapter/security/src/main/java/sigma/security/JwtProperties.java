package sigma.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
class JwtProperties {

    private String accessKey;
    private String secretKey;
    private String accessExpire;
    private String refreshExpire;

}