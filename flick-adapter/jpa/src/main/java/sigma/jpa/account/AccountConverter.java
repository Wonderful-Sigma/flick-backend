package sigma.jpa.account;

import sigma.domain.account.model.Account;
import sigma.domain.account.model.value.*;
import sigma.domain.member.model.value.MemberId;

abstract class AccountConverter {

    static Account toDomain(final AccountJPAEntity entity) {
        if(entity == null) {
            return null;
        }

        return Account.builder()
                .id(new AccountId(entity.getId()))
                .accountInfo(new AccountInfo(entity.getNumber(), entity.getName()))
                .holderId(new HolderId(new MemberId(entity.getHolderId())))
                .balance(new Balance(entity.getBalance()))
                .type(entity.getType())
                .profile(new Profile(entity.getProfileImage()))
                .build();
    }

    static AccountJPAEntity toEntity(final Account domain) {
        try {
            return AccountJPAEntity.builder()
                    .id(domain.id().getId())
                    .number(domain.accountInfo().number())
                    .name(domain.accountInfo().name())
                    .holderId(domain.holderId().getId())
                    .balance(domain.balance().getValue())
                    .type(domain.type())
                    .profileImage(domain.profile().profileUrl())
                    .createdAt(domain.createdAt())
                    .modifiedAt(domain.modifiedAt())
                    .build();
        } catch (NullPointerException e) {
            return AccountJPAEntity.builder()
                    .number(domain.accountInfo().number())
                    .name(domain.accountInfo().name())
                    .holderId(domain.holderId().getId())
                    .balance(domain.balance().getValue())
                    .type(domain.type())
                    .profileImage(domain.profile().profileUrl())
                    .build();
        }
    }

}