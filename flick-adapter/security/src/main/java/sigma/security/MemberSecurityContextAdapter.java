package sigma.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sigma.application.member.outport.MemberSessionPort;
import sigma.domain.member.model.Member;

@Component
@RequiredArgsConstructor
class MemberSecurityContextAdapter implements MemberSessionPort {

    @Override
    public Member current() {
        return ((MemberDetailAdapter) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).member();
    }

}