package com.example.demo.exception;

public class CheckingAccountException extends BaseException {

	private static final long serialVersionUID = 1L;

	public CheckingAccountException(
            final ErrorCodeEnum errorCodeEnum,
            final ErrorMessages errorMessages,
            final String message) {
        super(errorCodeEnum, errorMessages, message);
    }
}
