package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.enums.LoanType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class LoanApplicationRequest {
    @NotNull
    private LoanType loanType;

    @Positive
    private BigDecimal loanAmount;

    @Positive
    private Integer tenureMonths;
}
