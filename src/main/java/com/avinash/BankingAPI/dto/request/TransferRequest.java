package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TransferRequest {
    @NotBlank
    private String fromAccountNumber;

    @NotNull
    private Long beneficiaryId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

    private String remarks;
}
