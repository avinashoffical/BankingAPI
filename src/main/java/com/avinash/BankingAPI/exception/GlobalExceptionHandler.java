package com.avinash.BankingAPI.exception;

import com.avinash.BankingAPI.dto.response.APIResponse;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AccountBlockedException.class)
    public ResponseEntity<APIResponse> handleAccountBlockedException(AccountBlockedException e) {
        logger.error("Account blocked: {}",e.getMessage());
        return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<APIResponse> handleAccountNotFoundException(AccountNotFoundException e) {
        logger.error("Account not found: {}",e.getMessage());
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<APIResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
        logger.error("Customer not found: {}",e.getMessage());
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<APIResponse>  handleDuplicateResourceException(DuplicateResourceException e) {
        logger.error("Duplicate resource found: {}",e.getMessage());
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<APIResponse>  handleInsufficientBalanceException(InsufficientBalanceException e) {
        logger.error("Insufficient balance: {}",e.getMessage());
        return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<APIResponse> handleInvalidTransactionException(InvalidTransactionException e) {
        logger.error("Invalid transaction: {}",e.getMessage());
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse>  handleResourceNotFoundException(ResourceNotFoundException e) {
        logger.error("Resource not found: {}",e.getMessage());
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<APIResponse> handleUsernameNotFoundException(UsernameNotFoundException e) {
        logger.error("Username not found: {}",e.getMessage());
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<APIResponse>  handleAccessDeniedException(AccessDeniedException e) {
        logger.error("Access denied: {}",e.getMessage());
        return buildResponse(HttpStatus.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<APIResponse> handleUnauthorizedException(UnauthorizedException e) {
        logger.error("Unauthorized: {}",e.getMessage());
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.error("Constraint violation: {}",ex.getMessage());
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
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
