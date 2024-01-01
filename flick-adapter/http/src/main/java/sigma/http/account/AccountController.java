package sigma.http.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sigma.application.account.interactor.TransferUseCase;
import sigma.application.account.interactor.command.TransferCommand;
import sigma.domain.account.model.Account;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
public class AccountController {

    private final TransferUseCase transferUseCase;

    @PatchMapping("/transfer")
    public Account transfer(@RequestBody TransferCommand command) {
        return transferUseCase.transfer(command);
    }

}