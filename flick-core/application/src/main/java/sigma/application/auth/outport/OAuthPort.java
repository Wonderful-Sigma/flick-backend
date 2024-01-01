package sigma.application.auth.outport;

import sigma.domain.member.model.Member;

public interface OAuthPort {

    Member getResource(String code);

}