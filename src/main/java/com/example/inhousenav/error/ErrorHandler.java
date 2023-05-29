package com.example.inhousenav.error;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

import static org.springframework.http.HttpStatus.*;


/**
 * Created by seymurmanafov on 2023. 05. 26..
 */
@Slf4j

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException ex) {
        log.error("Not Found error has occurred [{}]", ex.getMessage());
        return buildApiErrorMessage(NOT_FOUND, ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ApiError> handleIllegalArgException(IllegalArgumentException ex) {
        log.error("IllegalArgument error has occurred", ex);
        return buildApiErrorMessage(BAD_REQUEST, ex);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiError> handleGenericException(Exception ex) {
        log.error("Generic error has occurred", ex);
        return buildApiErrorMessage(INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<ApiError> buildApiErrorMessage(HttpStatus httpStatus, Exception ex) {
        ApiError apiError = new ApiError();
        apiError.setStatus(httpStatus);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage(ex.getMessage());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

}

