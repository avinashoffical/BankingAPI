package com.avinash.BankingAPI.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @NotBlank(message = "Current Password is Required")
    private String currentPassword;

    @NotBlank(message = "New Password is required")
    @Size(min = 8, max = 20)
    private String newPassword;

    @NotBlank
    private String confirmNewPassword;
}
