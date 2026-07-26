package com.avinash.BankingAPI.dto.response;

import com.avinash.BankingAPI.entity.enums.AccountType;

import java.math.BigDecimal;

public class AccountDTO {
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
    private String status;
}
