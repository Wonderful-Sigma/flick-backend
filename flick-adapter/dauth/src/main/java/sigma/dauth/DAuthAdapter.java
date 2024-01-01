package sigma.dauth;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.DAuthException;
import com.b1nd.dauth.client.response.DAuthTokenInfo;
import com.b1nd.dauth.client.response.DAuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.auth.outport.OAuthPort;
import sigma.domain.member.model.Member;

import static sigma.dauth.MemberConverter.*;

@Component
@RequiredArgsConstructor
class DAuthAdapter implements OAuthPort {

    private final DAuth dAuth;

    @Override
    public Member getResource(final String code) {
        final DAuthTokenInfo tokenInfo;
        final DAuthUser user;

        try {
            tokenInfo = dAuth.issueToken(code);
            user = dAuth.getUser(tokenInfo.getAccessToken()).getUser();
        } catch (DAuthException e) {
            throw new OAuthException(e.getStatus(), e.getMessage());
        }

        return toDomain(user);
    }

}