package sigma.domain.common.exception;

import lombok.Getter;

@Getter
public abstract class FlickException extends RuntimeException {

    private final int status;
    private final String message;

    protected FlickException(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

}