package sigma.dauth;

import sigma.domain.common.exception.FlickException;

public final class OAuthException extends FlickException {

    OAuthException(final int status, final String message) {
        super(status, message);
    }

}