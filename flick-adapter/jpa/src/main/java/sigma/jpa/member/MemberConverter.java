package sigma.jpa.member;

import sigma.domain.member.model.Member;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.StudentInfo;

abstract class MemberConverter {

    static Member toDomain(final MemberJPAEntity entity) {
        if(entity == null) {
            return null;
        }

        final MemberInfo memberInfo = new MemberInfo(entity.getRole(), entity.getProfileImage(), entity.getSmsToken(),
                entity.getCreatedAt(), entity.getModifiedAt());
        final StudentInfo studentInfo = new StudentInfo(entity.getStudentNumber(), entity.getStudentName());

        return Member.builder()
                .id(new MemberId(entity.getId()))
                .memberInfo(memberInfo)
                .studentInfo(studentInfo)
                .build();
    }

    static MemberJPAEntity toEntity(final Member domain) {
        try {
            return MemberJPAEntity.builder()
                    .id(domain.id().getId())
                    .role(domain.memberInfo().role())
                    .profileImage(domain.memberInfo().profileImage())
                    .smsToken(domain.memberInfo().smsToken())
                    .studentName(domain.studentInfo().name())
                    .studentNumber(domain.studentInfo().number())
                    .createdAt(domain.memberInfo().createdAt())
                    .modifiedAt(domain.memberInfo().modifiedAt())
                    .build();
        } catch (NullPointerException e) {
            return MemberJPAEntity.builder()
                    .role(domain.memberInfo().role())
                    .profileImage(domain.memberInfo().profileImage())
                    .studentName(domain.studentInfo().name())
                    .studentNumber(domain.studentInfo().number())
                    .build();
        }
    }

}