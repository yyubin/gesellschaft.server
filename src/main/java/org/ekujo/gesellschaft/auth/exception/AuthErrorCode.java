package org.ekujo.gesellschaft.auth.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements BaseErrorCode {
    USERNAME_NOT_FOUND("AUTH_001", "해당 회원을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;
}
