package sigma.domain.member.model;

import lombok.Builder;
import sigma.domain.member.model.value.*;

import java.time.LocalDateTime;
import java.util.UUID;

public final class Member {

    private final MemberId id;
    private final Role role;
    private MemberInfo memberInfo;
    private StudentInfo studentInfo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder(builderMethodName = "WithId")
    public Member(final MemberId id, final Role role, final MemberInfo memberInfo, final StudentInfo studentInfo,
                  final LocalDateTime createdAt, final LocalDateTime modifiedAt) {
        this.id = id;
        this.role = role;
        this.memberInfo = memberInfo;
        this.studentInfo = studentInfo;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    @Builder(builderMethodName = "ExceptId")
    public Member(final Role role, final MemberInfo memberInfo,
                  final Integer grade, final Integer room, final Integer number, final String name) {
        StudentInfo studentInfo = toStudentInfo(role, grade, room, number, name);

        this.id = null;
        this.role = role;
        this.memberInfo = memberInfo;
        this.studentInfo = studentInfo;
    }

    private StudentInfo toStudentInfo(final Role role, final Integer grade, final Integer room, final Integer number, final String name) {
        String studentNumber;

        if(Role.TEACHER.equals(role)) {
            studentNumber = UUID.randomUUID().toString();
        } else {
            studentNumber = grade + room + (number>9 ? "" : "0") + number;
        }

        return new StudentInfo(studentNumber, name);
    }

    public MemberId id() {
        return id;
    }

    public Role role() {
        return role;
    }

    public MemberInfo memberInfo() {
        return memberInfo;
    }

    public StudentInfo studentInfo() {
        return studentInfo;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

}