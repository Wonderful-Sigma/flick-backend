package sigma.domain.account.model.exception;

import sigma.domain.common.exception.FlickException;

public class NotAccountHolder extends FlickException {

    public static final FlickException EXCEPTION = new NotAccountHolder();

    private NotAccountHolder() {
        super(403, "계좌주가 아닙니다.");
    }

}