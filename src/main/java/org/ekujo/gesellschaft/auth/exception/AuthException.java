package org.ekujo.gesellschaft.auth.exception;

import org.ekujo.gesellschaft.persona.exception.PersonaErrorCode;

public class AuthException extends RuntimeException {
    private final AuthErrorCode errorCode;

    public AuthException(AuthErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public AuthErrorCode getErrorCode() {
        return errorCode;
    }
}
