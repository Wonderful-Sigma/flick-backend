package sigma.application.account.outport;

import sigma.domain.account.model.Account;
import sigma.domain.account.model.exception.AccountNotFound;

import java.util.Optional;

public interface AccountDBPort {

    Account save(Account account);

    Optional<Account> findById(Long id);

    default Account getById(final Long id) {
        return findById(id)
                .orElseThrow(() -> AccountNotFound.EXCEPTION);
    }

    Optional<Account> findByNumber(Long number);

    default Account getByNumber(final Long number) {
        return findByNumber(number)
                .orElseThrow(() -> AccountNotFound.EXCEPTION);
    }

}