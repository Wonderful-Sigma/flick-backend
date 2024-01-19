package sigma.application.member.interactor.response;

import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.StudentInfo;

public record MemberFindByNameResponse(
        MemberId memberId,
        StudentInfo studentInfo,
        MemberInfo memberInfo
) { }
