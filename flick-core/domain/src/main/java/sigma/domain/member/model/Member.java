package sigma.domain.member.model;

import lombok.Builder;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.StudentInfo;

public final class Member {
    private final MemberId id;
    private MemberInfo memberInfo;
    private StudentInfo studentInfo;

    @Builder
    public Member(final MemberId id, final MemberInfo memberInfo, final StudentInfo studentInfo) {
        this.id = id;
        this.memberInfo = memberInfo;
        this.studentInfo = studentInfo;
    }

    public MemberId id() {
        return id;
    }

    public MemberInfo memberInfo() {
        return memberInfo;
    }

    public StudentInfo studentInfo() {
        return studentInfo;
    }

}