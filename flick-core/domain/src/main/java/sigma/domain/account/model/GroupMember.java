package sigma.domain.account.model;

import lombok.Builder;
import sigma.domain.account.model.value.AccountId;
import sigma.domain.account.model.value.GroupMemberId;
import sigma.domain.member.model.value.MemberId;

import java.time.LocalDateTime;

public record GroupMember(
        GroupMemberId id,
        MemberId memberId,
        AccountId accountId,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt) {

    @Builder
    public GroupMember {
    }

}