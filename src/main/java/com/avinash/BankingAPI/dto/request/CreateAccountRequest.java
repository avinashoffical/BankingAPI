package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.entity.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
    @NotNull
    private AccountType accountType;

    @PositiveOrZero
    private BigDecimal initialDeposit = BigDecimal.ZERO;
}
