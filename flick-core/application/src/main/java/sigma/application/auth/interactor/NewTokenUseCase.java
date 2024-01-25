package sigma.application.auth.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.auth.outport.TokenPort;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;
import sigma.domain.member.model.value.Role;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NewTokenUseCase {
    private final TokenPort tokenPort;
    private final MemberDBPort memberDBPort;

    public String newAccessToKen(String token) {
        final String id = tokenPort.parseToken(token, "REFRESH");
        final Role role = memberDBPort.findById(id).orElseThrow().role(); // 이거 고칠 수 있나?
        return tokenPort.newAccessToken(id,role);
    }

    public void setNewFirebaseToken(String memberId, String firebaseToken) {
        Member member = memberDBPort.getById(memberId);

        // login 부분 알아야 될것 같음
    }
}
