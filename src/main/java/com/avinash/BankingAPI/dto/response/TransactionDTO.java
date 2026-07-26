package com.avinash.BankingAPI.dto.response;

import com.avinash.BankingAPI.entity.enums.PaymentMethod;
import com.avinash.BankingAPI.entity.enums.TransactionStatus;
import com.avinash.BankingAPI.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private Long transactionId;

    private String referenceNumber;

    private TransactionType transactionType;

    private BigDecimal amount;

    private TransactionStatus status;

    private PaymentMethod paymentMethod;

    private String fromAccountNumber;

    private String toAccountNumber;

    private String description;

    private LocalDateTime transactionDate;
}

