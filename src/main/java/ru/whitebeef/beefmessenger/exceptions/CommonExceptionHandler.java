package ru.whitebeef.beefmessenger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.whitebeef.beefmessenger.dto.ErrorResponse;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleIncorrectCredentialsException(IncorrectCredentialsException ex) {
        return ResponseEntity
                .badRequest().body(ErrorResponse.builder()
                        .errorMessage(ex.getMessage())
                        .errorCode(HttpStatus.UNAUTHORIZED.value())
                        .build());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> usernameNotFoundException(UsernameNotFoundException ex) {
        return ResponseEntity
                .badRequest().body(ErrorResponse.builder()
                        .errorMessage(ex.getMessage())
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

}
