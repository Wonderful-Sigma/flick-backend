package sigma.application.account.outport;

import sigma.domain.account.model.GroupMember;

public interface GroupMemberDBPort {

    GroupMember save(GroupMember groupMember);

    boolean existsByMemberAndAccount(Long memberId, Long accountId);

}