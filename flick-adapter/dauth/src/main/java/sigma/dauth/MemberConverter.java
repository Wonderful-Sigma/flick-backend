package sigma.dauth;

import com.b1nd.dauth.client.response.DAuthUser;
import sigma.domain.member.model.Member;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.Role;

abstract class MemberConverter {

    public static Member toDomain(final DAuthUser user) {
        return Member.ExceptId()
                .role(Role.valueOf(user.getRole()))
                .memberInfo(new MemberInfo(null, user.getProfileImage()))
                .grade(user.getGrade())
                .room(user.getRoom())
                .number(user.getNumber())
                .name(user.getName())
                .build();
    }

}