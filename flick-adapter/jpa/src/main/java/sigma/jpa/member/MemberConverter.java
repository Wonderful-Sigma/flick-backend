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

        final MemberInfo memberInfo = new MemberInfo(entity.getProfileImage(), entity.getFcmToken());
        final StudentInfo studentInfo = new StudentInfo(entity.getStudentNumber(), entity.getStudentName());

        return Member.WithId()
                .id(new MemberId(entity.getId()))
                .memberInfo(memberInfo)
                .studentInfo(studentInfo)
                .build();
    }

    static MemberJPAEntity toEntity(final Member domain) {
        try {
            return MemberJPAEntity.builder()
                    .id(domain.id().getId())
                    .role(domain.role())
                    .profileImage(domain.memberInfo().profileUrl())
                    .fcmToken(domain.memberInfo().fcmToken())
                    .studentName(domain.studentInfo().name())
                    .studentNumber(domain.studentInfo().number())
                    .createdAt(domain.createdAt())
                    .modifiedAt(domain.modifiedAt())
                    .build();
        } catch (NullPointerException e) {
            return MemberJPAEntity.builder()
                    .role(domain.role())
                    .profileImage(domain.memberInfo().profileUrl())
                    .studentName(domain.studentInfo().name())
                    .studentNumber(domain.studentInfo().number())
                    .build();
        }
    }

}