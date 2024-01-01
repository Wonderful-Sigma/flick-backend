package sigma.domain.member.model;

import lombok.Builder;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.StudentInfo;

public record Member(
        MemberId id,
        MemberInfo memberInfo,
        StudentInfo studentInfo) {

    @Builder
    public Member {
    }

}