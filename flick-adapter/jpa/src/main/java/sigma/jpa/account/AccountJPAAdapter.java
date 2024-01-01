package sigma.jpa.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.account.outport.AccountDBPort;
import sigma.domain.account.model.Account;

import java.util.Optional;

import static sigma.jpa.account.AccountConverter.*;

@Component
@RequiredArgsConstructor
class AccountJPAAdapter implements AccountDBPort {

    private final AccountJPARepository repository;

    @Override
    public Account save(final Account account) {
        return toDomain(repository.save(toEntity(account)));
    }

    @Override
    public Optional<Account> findById(final Long id) {
        return Optional.ofNullable(toDomain(repository.findById(id).orElse(null)));
    }

    @Override
    public Optional<Account> findByNumber(final Long number) {
        return Optional.ofNullable(toDomain(repository.findByNumber(number).orElse(null)));
    }

}