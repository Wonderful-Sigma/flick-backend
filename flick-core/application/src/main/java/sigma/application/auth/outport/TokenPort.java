package sigma.application.auth.outport;

import sigma.application.auth.interactor.response.TokenResponse;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.Role;

public interface TokenPort {

    String parseToken(String accessToken, String jwtType);

    TokenResponse issueToken(MemberId id, Role role);

    String newAccessToken(String id, Role role);

}