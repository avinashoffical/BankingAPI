package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.*;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.JwtResponse;
import com.avinash.BankingAPI.dto.response.UserResponse;
import jakarta.validation.Valid;

public interface AuthService {
    APIResponse register(@Valid RegisterRequest registerRequest);

    JwtResponse login(@Valid LoginRequest loginRequest);

    UserResponse getCurrentUser();

    APIResponse changePassword(@Valid ChangePasswordRequest changePasswordRequest);

    JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    APIResponse logout();

    APIResponse forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

    APIResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
}
