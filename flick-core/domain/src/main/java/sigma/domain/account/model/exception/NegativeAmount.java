package sigma.domain.account.model.exception;

import lombok.Getter;
import sigma.domain.common.exception.FlickException;

@Getter
public final class NegativeAmount extends FlickException {

    public static final FlickException EXCEPTION = new NegativeAmount();

    private NegativeAmount() {
        super(400, "송금 금액이 0보다 커야합니다.");
    }

}