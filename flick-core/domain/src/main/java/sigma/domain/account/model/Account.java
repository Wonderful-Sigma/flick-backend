package sigma.domain.account.model;

import lombok.Builder;
import sigma.domain.account.model.exception.InsufficientBalance;
import sigma.domain.account.model.exception.NotAccountHolder;
import sigma.domain.account.model.value.*;
import sigma.domain.common.value.AbstractId;

import java.time.LocalDateTime;

public final class Account {

    private final AccountId id;
    private final AccountInfo accountInfo;
    private final AccountType type;
    private final HolderId holderId;
    private Balance balance;
    private Profile profile;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public Account(final AccountId id, final AccountInfo accountInfo, final HolderId holderId, final Balance balance,
                   final AccountType type, final Profile profile, final LocalDateTime createdAt, final LocalDateTime modifiedAt) {
        this.id = id;
        this.accountInfo = accountInfo;
        this.holderId = holderId;
        this.balance = balance;
        this.type = type;
        this.profile = profile;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    private void isHolder(final AbstractId memberId) {
        if (!holderId.equals(memberId)) {
            throw NotAccountHolder.EXCEPTION;
        }
    }

    private void canAfford(final Long amount) {
        if (balance.getValue() < amount) {
            throw InsufficientBalance.EXCEPTION;
        }
    }

    public void send(final Long amount, final AbstractId memberId) {
        isHolder(memberId);
        canAfford(amount);

        this.balance = new Balance(this.balance.getValue() - amount);
    }

    public void receive(final Long amount) {
        this.balance = new Balance(this.balance.getValue() + amount);
    }

    public AccountId id() {
        return id;
    }

    public AccountInfo accountInfo() {
        return accountInfo;
    }

    public HolderId holderId() {
        return holderId;
    }

    public Balance balance() {
        return balance;
    }

    public AccountType type() {
        return type;
    }

    public Profile profile() {
        return profile;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

}