package sigma.jpa.account;

import sigma.domain.account.model.Account;
import sigma.domain.account.model.value.AccountId;
import sigma.domain.account.model.value.AccountNumber;
import sigma.domain.account.model.value.Balance;
import sigma.domain.account.model.value.HolderId;

abstract class AccountConverter {

    static Account toDomain(final AccountJPAEntity entity) {
        if(entity == null) {
            return null;
        }

        return Account.builder()
                .id(new AccountId(entity.getId()))
                .number(new AccountNumber(entity.getNumber()))
                .holderId(new HolderId(entity.getHolderId()))
                .balance(new Balance(entity.getBalance()))
                .type(entity.getType())
                .build();
    }

    static AccountJPAEntity toEntity(final Account domain) {
        try {
            return AccountJPAEntity.builder()
                    .id(domain.id().getId())
                    .number(domain.number().value())
                    .holderId(domain.holderId().getId())
                    .balance(domain.balance().getValue())
                    .type(domain.type())
                    .createdAt(domain.createdAt())
                    .modifiedAt(domain.modifiedAt())
                    .build();
        } catch (NullPointerException e) {
            return AccountJPAEntity.builder()
                    .number(domain.number().value())
                    .holderId(domain.holderId().getId())
                    .balance(domain.balance().getValue())
                    .type(domain.type())
                    .build();
        }
    }

}