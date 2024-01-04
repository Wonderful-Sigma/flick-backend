package sigma.domain.account.model;

import lombok.Builder;
import sigma.domain.account.model.exception.InsufficientBalance;
import sigma.domain.account.model.exception.NotAccountHolder;
import sigma.domain.account.model.value.*;
import sigma.domain.common.value.AbstractId;

import java.time.LocalDateTime;

public final class Account {
    private final AccountId id;
    private AccountNumber number;
    private HolderId holderId;
    private Balance balance;
    private AccountType type;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    @Builder
    public Account(final AccountId id, final AccountNumber number, final HolderId holderId, final Balance balance,
                   final AccountType type, final LocalDateTime createdAt, final LocalDateTime modifiedAt) {
        this.id = id;
        this.number = number;
        this.holderId = holderId;
        this.balance = balance;
        this.type = type;
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

    public AccountNumber number() {
        return number;
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

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

}