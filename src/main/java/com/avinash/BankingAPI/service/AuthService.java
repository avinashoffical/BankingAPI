package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.*;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.JwtResponse;
import com.avinash.BankingAPI.dto.response.MessageResponse;

public interface AuthService {
    MessageResponse signup(SignupRequest signupRequest);

    JwtResponse login(LoginRequest loginRequest);

    MessageResponse getCurrentUser();

    APIResponse changePassword(ChangePasswordRequest changePasswordRequest);

    JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    APIResponse logout();

    APIResponse forgotPassword();

    APIResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
}
