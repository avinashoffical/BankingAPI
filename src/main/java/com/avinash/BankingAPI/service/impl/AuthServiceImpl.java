package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.*;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.JwtResponse;
import com.avinash.BankingAPI.dto.response.UserResponse;
import com.avinash.BankingAPI.repository.CustomerRepository;
import com.avinash.BankingAPI.repository.RoleRepository;
import com.avinash.BankingAPI.repository.UserRepository;
import com.avinash.BankingAPI.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Override
    public APIResponse register(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public UserResponse getCurrentUser() {
        return null;
    }

    @Override
    public APIResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }

    @Override
    public APIResponse logout() {
        return null;
    }

    @Override
    public APIResponse forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        return null;
    }

    @Override
    public APIResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
        return null;
    }
}
