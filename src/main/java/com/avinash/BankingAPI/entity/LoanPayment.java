package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.LoanType;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
public class LoanPayment {
    private Long paymentId;

    private LoanType loan;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    private BigInteger transactionReference;
}
