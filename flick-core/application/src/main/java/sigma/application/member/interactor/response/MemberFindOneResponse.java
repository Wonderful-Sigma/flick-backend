package sigma.application.member.interactor.response;

import sigma.domain.account.model.Account;
import sigma.domain.member.model.value.MemberId;
import sigma.domain.member.model.value.MemberInfo;
import sigma.domain.member.model.value.Role;
import sigma.domain.member.model.value.StudentInfo;

import java.util.List;

public record MemberFindOneResponse(
        MemberId memberId,
        StudentInfo studentInfo,
        MemberInfo memberInfo,
        Role role,
        List<Account> accounts
) { }
