package sigma.domain.account.model;

import lombok.Builder;
import sigma.domain.account.model.value.AccountId;
import sigma.domain.account.model.value.GroupMemberId;
import sigma.domain.member.model.value.MemberId;

import java.time.LocalDateTime;

public final class GroupMember {
    private final GroupMemberId id;
    private MemberId memberId;
    private AccountId accountId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public GroupMember(final GroupMemberId id, final MemberId memberId, final AccountId accountId,
                       final LocalDateTime createdAt, final LocalDateTime modifiedAt) {
        this.id = id;
        this.memberId = memberId;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public GroupMemberId id() {
        return id;
    }

    public MemberId memberId() {
        return memberId;
    }

    public AccountId accountId() {
        return accountId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

}