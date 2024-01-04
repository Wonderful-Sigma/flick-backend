package sigma.domain.account.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sigma.domain.account.model.exception.InsufficientBalance;
import sigma.domain.account.model.exception.NotAccountHolder;
import sigma.domain.account.model.value.*;
import sigma.domain.member.model.value.MemberId;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    private Account account;
    private HolderId holderId;

    @BeforeEach
    void setUp() {
        final Balance balance = new Balance(1000L);
        holderId = new HolderId(1L);
        account = Account.builder()
                .id(new AccountId(1L))
                .number(new AccountNumber(2317L))
                .holderId(holderId)
                .balance(balance)
                .type(AccountType.INDIVIDUAL)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
    }

    @Test
    @DisplayName(value = "Holder 가 아닐 경우 송금 불가")
    void HOLDER_가_아닐_경우_송금_불가() {
        final MemberId memberId = new MemberId(3L);

        assertThrows(NotAccountHolder.class, () -> account.send(500L, memberId));
    }

    @Test
    @DisplayName(value = "잔액이 부족할 경우 송금 불가")
    void 잔액이_부족할_경우_송금_불가() {
        assertThrows(InsufficientBalance.class, () -> account.send(9999L, holderId));
    }

    @Test
    @DisplayName(value = "송금 성공")
    void 송금_성공() {
        account.send(500L, holderId);

        assertEquals(500L, account.balance().getValue());
    }

    @Test
    @DisplayName(value = "Receive 성공")
    void RECEIVE_성공() {
        account.receive(500L);

        assertEquals(1500L, account.balance().getValue());
    }

}