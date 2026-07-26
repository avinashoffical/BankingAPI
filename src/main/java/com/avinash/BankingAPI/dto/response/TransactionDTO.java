package com.avinash.BankingAPI.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private String transactionId;
    private String referenceNumber;
    private BigDecimal amount;
    private String transactionType;
    private String status;
    private LocalDateTime createdAt;
}
