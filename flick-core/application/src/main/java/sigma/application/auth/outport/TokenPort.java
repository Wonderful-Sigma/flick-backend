package sigma.application.auth.outport;

import sigma.application.auth.interactor.response.TokenResponse;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.Role;

public interface TokenPort {

    Long parseAccessToken(String accessToken);

    TokenResponse issueToken(MemberId id, Role role);

}