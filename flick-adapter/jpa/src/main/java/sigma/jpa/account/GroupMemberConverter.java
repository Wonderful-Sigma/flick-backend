package sigma.jpa.account;

import sigma.domain.account.model.GroupMember;
import sigma.domain.account.model.value.AccountId;
import sigma.domain.account.model.value.GroupMemberId;
import sigma.domain.member.model.value.MemberId;

abstract class GroupMemberConverter {

    static GroupMember toDomain(final GroupMemberJPAEntity entity) {
        if(entity == null) {
            return null;
        }

        return GroupMember.builder()
                .id(new GroupMemberId(entity.getId()))
                .memberId(new MemberId(entity.getMemberId()))
                .accountId(new AccountId(entity.getAccountId()))
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }

    static GroupMemberJPAEntity toEntity(final GroupMember domain) {
        try {
            return GroupMemberJPAEntity.builder()
                    .id(domain.id().getId())
                    .memberId(domain.memberId().getId())
                    .accountId(domain.accountId().getId())
                    .createdAt(domain.createdAt())
                    .modifiedAt(domain.modifiedAt())
                    .build();
        } catch (NullPointerException e) {
            return GroupMemberJPAEntity.builder()
                    .memberId(domain.memberId().getId())
                    .accountId(domain.accountId().getId())
                    .build();
        }
    }

}