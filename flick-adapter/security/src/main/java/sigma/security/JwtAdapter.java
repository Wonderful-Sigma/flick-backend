package sigma.security;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sigma.application.auth.outport.TokenPort;
import sigma.application.auth.interactor.response.TokenResponse;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.Role;

import java.util.Date;

@Component
@RequiredArgsConstructor
class JwtAdapter implements TokenPort {

    private final JwtProperties jwtProperties;

    @Override
    public Long parseAccessToken(final String accessToken) {
        final String key = jwtProperties.getAccessKey();

        final Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(key).parseClaimsJws(extract(accessToken));

        if(!(jwsClaims.getHeader().get(Header.JWT_TYPE).equals(JwtType.ACCESS.toString()))) {
            throw WrongTokenType.EXCEPTION;
        }

        return Long.parseLong(jwsClaims.getBody().getSubject());
    }

    @Override
    public TokenResponse issueToken(final MemberId id, final Role role) {
        return new TokenResponse(
                generateToken(id.getId(), role, JwtType.ACCESS),
                generateToken(id.getId(), role, JwtType.REFRESH)
        );
    }

    static String extract(final String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }

        return token;
    }

    private String generateToken(final Long id, final Role role, final JwtType jwtType) {
        final String key;
        final String expire;

        switch (jwtType) {
            case ACCESS -> {
                key = jwtProperties.getAccessKey();
                expire = jwtProperties.getAccessExpire();
            }
            case REFRESH -> {
                key = jwtProperties.getSecretKey();
                expire = jwtProperties.getRefreshExpire();
            }
            default -> throw new IllegalStateException("Unexpected value: " + jwtType);
        }

        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, jwtType)
                .setSubject(id.toString())
                .claim("authority", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

}