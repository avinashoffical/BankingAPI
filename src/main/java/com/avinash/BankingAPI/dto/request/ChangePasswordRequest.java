package com.avinash.BankingAPI.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangePasswordRequest {
    @NotBlank
    private String currentPassword;

    @NotBlank
    @Size(min = 8, max = 20)
    private String newPassword;

    @NotBlank
    private String confirmNewPassword;
}
