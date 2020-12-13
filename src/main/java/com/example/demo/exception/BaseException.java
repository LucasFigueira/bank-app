package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCodeEnum errorCodeEnum;
    private ErrorMessages errorMessages;

    public BaseException(
            final ErrorCodeEnum errorCodeEnum,
            final ErrorMessages errorMessages,
            final String message) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
        this.errorMessages = errorMessages;
    }

    public String getErrorMessage() {
        return errorMessages.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorMessages.getHttpStatus();
    }
}