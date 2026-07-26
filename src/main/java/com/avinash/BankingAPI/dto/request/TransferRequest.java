package com.avinash.BankingAPI.dto.request;

import java.math.BigDecimal;

public class TransferRequest {
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal amount;
    private String remark;
}
