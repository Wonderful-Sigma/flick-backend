package sigma.application.account.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import sigma.application.account.outport.AccountDBPort;
import sigma.application.account.outport.GroupMemberDBPort;
import sigma.domain.account.model.Account;
import sigma.domain.account.model.GroupMember;
import sigma.domain.account.model.value.AccountType;
import sigma.domain.account.model.value.Balance;
import sigma.domain.account.model.value.HolderId;
import sigma.domain.member.model.event.MemberRegisteredEvent;

@Component
@RequiredArgsConstructor
public class AccountEventListener {

    private final AccountDBPort accountDBPort;
    private final GroupMemberDBPort groupMemberDBPort;

    @TransactionalEventListener
    public void listen(final MemberRegisteredEvent event) {
        final Account account = accountDBPort.save(Account.builder()
                .holderId(new HolderId(event.id()))
                .balance(new Balance(0L))
                .type(AccountType.INDIVIDUAL)
                .build());

        groupMemberDBPort.save(GroupMember.builder()
                .memberId(event.id())
                .accountId(account.id())
                .build());
    }

}