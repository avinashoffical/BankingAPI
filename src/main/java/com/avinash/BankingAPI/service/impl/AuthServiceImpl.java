package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.*;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.JwtResponse;
import com.avinash.BankingAPI.dto.response.MessageResponse;
import com.avinash.BankingAPI.entity.Role;
import com.avinash.BankingAPI.entity.User;
import com.avinash.BankingAPI.enums.RoleName;
import com.avinash.BankingAPI.exception.EmailAlreadyExistException;
import com.avinash.BankingAPI.exception.ResourceNotFoundException;
import com.avinash.BankingAPI.exception.UsernameAlreadyExistsException;
import com.avinash.BankingAPI.repository.RoleRepository;
import com.avinash.BankingAPI.repository.UserRepository;
import com.avinash.BankingAPI.security.jwt.JwtUtil;
import com.avinash.BankingAPI.service.AuthService;
import jakarta.transaction.Transactional;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public MessageResponse signup(SignupRequest signupRequest) {
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            throw new EmailAlreadyExistException("Email already exists");
        }
        Role role = roleRepository.FindByRoleName(RoleName.CUSTOMER)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.getRoles().add(role);
        userRepository.save(user);
        return new MessageResponse("User Registered successfully");
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public MessageResponse getCurrentUser() {
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
    public APIResponse forgotPassword() {
        return null;
    }

    @Override
    public APIResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
        return null;
    }
}
