package com.avinash.BankingAPI.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddBeneficiaryRequest {
    @NotBlank
    private String nickname;

    @NotBlank
    private String accountHolderName;

    @Pattern(regexp = "\\d{10,18}")
    private String accountNumber;

    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$")
    private String ifscCode;

    @NotBlank
    private String bankName;
}
