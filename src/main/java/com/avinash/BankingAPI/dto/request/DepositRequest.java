package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class DepositRequest {
    @NotBlank
    private String accountNumber;

    @NotNull
    @DecimalMin(value = "1")
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

    @Size(max = 200)
    private String remarks;
}
