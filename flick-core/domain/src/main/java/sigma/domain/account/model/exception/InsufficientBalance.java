package sigma.domain.account.model.exception;

import sigma.domain.common.exception.FlickException;

public final class InsufficientBalance extends FlickException {

    public static final FlickException EXCEPTION = new InsufficientBalance();

    private InsufficientBalance() {
        super(403, "잔액이 부족합니다.");
    }

}