package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.entity.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class CreateAccountRequest {
    @NotNull
    private AccountType accountType;

    @PositiveOrZero
    private BigDecimal initialDeposit;
}
