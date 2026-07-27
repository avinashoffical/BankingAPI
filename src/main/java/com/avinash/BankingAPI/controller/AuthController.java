package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.*;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.JwtResponse;
import com.avinash.BankingAPI.dto.response.UserResponse;
import com.avinash.BankingAPI.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(authService.register(registerRequest),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.login(loginRequest),HttpStatus.ACCEPTED);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser() {
        return new ResponseEntity<>(authService.getCurrentUser(),HttpStatus.OK);
    }

    @PutMapping("/change-password")
    public ResponseEntity<APIResponse> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return new ResponseEntity<>(authService.changePassword(changePasswordRequest),HttpStatus.CREATED);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<JwtResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return new ResponseEntity<>(authService.refreshToken(refreshTokenRequest),HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<APIResponse> logout() {
        return new ResponseEntity<>(authService.logout(),HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<APIResponse> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        return new ResponseEntity<>(authService.forgotPassword(forgotPasswordRequest),HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<APIResponse> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        return new ResponseEntity<>(authService.resetPassword(resetPasswordRequest),HttpStatus.OK);
    }
}
