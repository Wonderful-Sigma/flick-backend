package sigma.application.member.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import sigma.application.member.interactor.response.MemberFindByNameResponse;
import sigma.application.member.interactor.response.MemberFindOneResponse;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;
import sigma.domain.member.model.event.MemberRegisteredEvent;
import sigma.domain.member.model.value.StudentInfo;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberFindUseCase {
    private final MemberDBPort memberDBPort;
    private final ApplicationEventPublisher applicationEventPublisher;


    public MemberFindOneResponse findOne(final String token){
        // 들어올 때 인증한 멤버 가져오기
        //지금은 그 부분이 어딘지 모르겠음
        return null;
    }

    public List<MemberFindByNameResponse> findByName(String name) {
        List<Member> members = memberDBPort.findByName(name);
        List<MemberFindByNameResponse> result = new ArrayList<>();
        for (Member member : members) {
            result.add(new MemberFindByNameResponse(member.id(),member.studentInfo(),member.memberInfo()));
//            applicationEventPublisher.publishEvent(new MemberRegisteredEvent(member.id()));
        }
        return result;
    }
}
