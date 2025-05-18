package org.ekujo.gesellschaft.persona.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PersonaErrorCode implements BaseErrorCode {
    PERSONA_NOT_FOUND("PERSONA_001", "해당 인격을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;
}
