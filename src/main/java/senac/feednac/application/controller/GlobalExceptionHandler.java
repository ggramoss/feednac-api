package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import senac.feednac.application.response.ApiErrorResponse;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> illegalArgumentExceptionHandler (IllegalArgumentException e) {
        return ResponseEntity.internalServerError().body(new ApiErrorResponse(500, List.of(e.getMessage())));
    }
}
