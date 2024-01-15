package sigma.domain.account.model.exception;

import sigma.domain.common.exception.FlickException;

public final class AccountNotFound extends FlickException {

    public static final FlickException EXCEPTION = new AccountNotFound();

    private AccountNotFound() {
        super(404, "계좌를 찾을 수 없습니다.");
    }

}