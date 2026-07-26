package com.avinash.BankingAPI.dto.response;

import com.avinash.BankingAPI.entity.enums.LoanStatus;
import com.avinash.BankingAPI.entity.enums.LoanType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanDTO {
    private Long loanId;

    private String loanNumber;

    private LoanType loanType;

    private BigDecimal loanAmount;

    private Double interestRate;

    private Integer tenureMonths;

    private BigDecimal monthlyEMI;

    private BigDecimal remainingAmount;

    private LoanStatus status;

    private LocalDateTime applicationDate;

    private LocalDateTime approvedDate;
}
