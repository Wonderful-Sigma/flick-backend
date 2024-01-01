package sigma.security;

import lombok.Getter;
import sigma.domain.common.exception.FlickException;

@Getter
final class WrongTokenType extends FlickException {

    public static final FlickException EXCEPTION = new WrongTokenType();

    private WrongTokenType() {
        super(400, "잘못된 토큰 타입입니다.");
    }

}