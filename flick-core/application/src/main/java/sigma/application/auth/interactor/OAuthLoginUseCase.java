package sigma.application.auth.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sigma.application.auth.outport.OAuthPort;
import sigma.application.auth.outport.TokenPort;
import sigma.application.auth.interactor.response.TokenResponse;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;
import sigma.domain.member.model.event.MemberRegisteredEvent;

@Component
@RequiredArgsConstructor
public class OAuthLoginUseCase {

    private final OAuthPort oAuthPort;
    private final MemberDBPort memberDBPort;
    private final TokenPort tokenPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public TokenResponse login(final String code) {
        final Member resource = oAuthPort.getResource(code);

        final Member member = memberDBPort.save(resource);

        applicationEventPublisher.publishEvent(new MemberRegisteredEvent(member.id()));

        return tokenPort.issueToken(member.id(), member.memberInfo().role());
    }

}