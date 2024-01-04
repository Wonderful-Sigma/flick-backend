package sigma.application.account.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sigma.application.account.interactor.command.TransferCommand;
import sigma.application.account.outport.AccountDBPort;
import sigma.application.member.outport.MemberSessionPort;
import sigma.domain.account.model.Account;
import sigma.domain.account.model.exception.NegativeAmount;
import sigma.domain.member.model.Member;

@Component
@RequiredArgsConstructor
public class TransferUseCase {

    private final MemberSessionPort memberSessionPort;
    private final AccountDBPort accountDBPort;

    @Transactional
    public Account transfer(final TransferCommand command) {
        if(command.amount() < 1) {
            throw NegativeAmount.EXCEPTION;
        }

        final Member member = memberSessionPort.current();
        final Account sender = accountDBPort.getByNumber(command.sender());
        final Account receiver = accountDBPort.getByNumber(command.receiver());

        sender.send(command.amount(), member.id());
        receiver.receive(command.amount());

        accountDBPort.save(sender);
        accountDBPort.save(receiver);

        return sender;
    }

}