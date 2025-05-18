package org.ekujo.gesellschaft.persona.exception;

public class PersonaException extends RuntimeException {
    private final PersonaErrorCode errorCode;

    public PersonaException(PersonaErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public PersonaErrorCode getErrorCode() {
      return errorCode;
    }
}
