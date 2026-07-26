package com.avinash.BankingAPI.dto.request;

import java.math.BigDecimal;

public class DepositRequest {
    private String accountNumber;
    private BigDecimal amount;
    private String remark;
}
