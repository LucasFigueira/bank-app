package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BaseException.class)
    public final ResponseEntity<Object> handleBaseException(final BaseException ex) {
        logger.error(ex.getErrorMessage(), ex);

        Fault exceptionResponse = new Fault()
                .code(ex.getErrorCodeEnum())
                .message(ex.getErrorMessage())
                .addDetailsItem(ex.getMessage());

        return ResponseEntity.status(ex.getHttpStatus()).body(exceptionResponse);
    }
}
