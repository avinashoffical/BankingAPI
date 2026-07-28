package com.avinash.BankingAPI.exception;

import com.avinash.BankingAPI.dto.response.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AccountBlockedException.class)
    public ResponseEntity<APIResponse> handleAccountBlockedException(AccountBlockedException e) {
        logger.error("AccountBlockedException: {}",e.getMessage());
        return buildResponse(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<APIResponse> handleBadCredentialsException(BadCredentialsException e) {
        logger.error("BadCredentialsException: {}",e.getMessage());
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<APIResponse>  handleDuplicateResourceException(DuplicateResourceException e) {
        logger.error("DuplicateResourceException: {}",e.getMessage());
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<APIResponse>  handleEmailAlreadyExistException(EmailAlreadyExistException e) {
        logger.error("EmailAlreadyExistException: {}", e.getMessage());
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<APIResponse>  handleInsufficientBalanceException(InsufficientBalanceException e) {
        logger.error("InsufficientBalanceException: {}",e.getMessage());
        return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }

    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<APIResponse>  handleInvalidRoleException(InvalidRoleException e) {
        logger.error("InvalidRoleException: {}",e.getMessage());
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<APIResponse>  handleInvalidTokenException(InvalidTokenException e) {
        logger.error("InvalidTokenException: {}",e.getMessage());
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<APIResponse> handleInvalidTransactionException(InvalidTransactionException e) {
        logger.error("InvalidTransactionException: {}",e.getMessage());
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse>  handleResourceNotFoundException(ResourceNotFoundException e) {
        logger.error("ResourceNotFoundException: {}",e.getMessage());
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<APIResponse> handleUnauthorizedException(UnauthorizedException e) {
        logger.error("UnauthorizedException: {}",e.getMessage());
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<APIResponse> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException e) {
        logger.error("UsernameAlreadyExistsException: {}",e.getMessage());
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> fieldErrors.put(err.getField(), err.getDefaultMessage()));

        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        body.put("message", "Validation failed");
        body.put("errors", fieldErrors);
        body.put("timestamp", LocalDateTime.now());

        logger.warn("Validation failed: {}", fieldErrors);
        return ResponseEntity.badRequest().body(body);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleException(Exception ex) {
        logger.error("Exception: {}",ex.getMessage());
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<APIResponse> buildResponse(HttpStatus status, String message) {
        APIResponse response = APIResponse.builder()
                .success(false)
                .message(message)
                .build();
        return new ResponseEntity<>(response, status);

    }
}
