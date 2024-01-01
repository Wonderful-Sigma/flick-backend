package sigma.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sigma.application.auth.outport.TokenPort;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;

@Component
@Slf4j
@RequiredArgsConstructor
class JwtHelper {

    private final TokenPort tokenPort;
    private final MemberDBPort memberDBPort;

    public void setAuthentication(final String accessToken) {
        if(accessToken != null) {
            final Long memberId = tokenPort.parseAccessToken(accessToken);

            final Member member = memberDBPort.getById(memberId);

            final Authentication authentication = getAuthentication(member);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private Authentication getAuthentication(final Member member) {
        final MemberDetailAdapter detail = new MemberDetailAdapter(member);

        return new UsernamePasswordAuthenticationToken(detail, null, detail.getAuthorities());
    }

}