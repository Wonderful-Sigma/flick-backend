package sigma.dauth;

import com.b1nd.dauth.client.response.DAuthUser;
import sigma.domain.member.model.Member;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.Role;
import sigma.domain.member.model.value.StudentInfo;

import java.util.UUID;

abstract class MemberConverter {

    public static Member toDomain(final DAuthUser user) {
        return Member.builder()
                .memberInfo(new MemberInfo(Role.valueOf(user.getRole()), user.getProfileImage(), null, null, null))
                .studentInfo(new StudentInfo(getStudentNumber(user), user.getName()))
                .build();
    }

    private static String getStudentNumber(final DAuthUser user) {
        if("TEACHER".equals(user.getRole())) {
            return UUID.randomUUID().toString();
        }

        final String number = "" + (user.getNumber()>9 ? "" : " ") + user.getNumber();

        return "" + user.getGrade() + "0" + user.getRoom() + number;
    }

}