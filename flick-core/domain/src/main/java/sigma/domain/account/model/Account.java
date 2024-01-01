package sigma.domain.account.model;

import lombok.Builder;
import sigma.domain.account.model.exception.InsufficientBalance;
import sigma.domain.account.model.exception.NotAccountHolder;
import sigma.domain.account.model.value.*;
import sigma.domain.common.value.AbstractId;

import java.time.LocalDateTime;

public record Account(
        AccountId id,
        AccountNumber number,
        HolderId holderId,
        Balance balance,
        AccountType type,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt) {

    @Builder
    public Account {
    }

    private void isHolder(final AbstractId memberId) {
        if(!holderId.equals(memberId)) {
            throw NotAccountHolder.EXCEPTION;
        }
    }

    private void canAfford(final Long amount) {
        if(balance.getValue() < amount) {
            throw InsufficientBalance.EXCEPTION;
        }
    }

    public Account send(final Long amount, final AbstractId memberId) {
        isHolder(memberId);
        canAfford(amount);

        final Balance balance = new Balance(this.balance.getValue()-amount);

        return new Account(id, number, holderId, balance, type, createdAt, modifiedAt);
    }

    public Account receive(final Long amount) {
        final Balance balance = new Balance(this.balance.getValue()+amount);

        return new Account(id, number, holderId, balance, type, createdAt, modifiedAt);
    }

}