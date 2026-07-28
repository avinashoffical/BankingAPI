package com.avinash.BankingAPI.dto.response;

import com.avinash.BankingAPI.enums.AccountStatus;
import com.avinash.BankingAPI.enums.AccountType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountDTO {
    private Long accountId;

    private String accountNumber;

    private BigDecimal balance;

    private AccountType accountType;

    private AccountStatus status;

    private LocalDateTime createdAt;
}
