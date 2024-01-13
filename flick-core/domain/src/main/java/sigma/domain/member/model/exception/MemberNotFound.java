package sigma.domain.member.model.exception;

import sigma.domain.common.exception.FlickException;

public final class MemberNotFound extends FlickException {

    public static final FlickException EXCEPTION = new MemberNotFound();

    private MemberNotFound() {
        super(404, "회원을 찾을 수 없습니다.");
    }

}