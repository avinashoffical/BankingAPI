package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.LoanStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Positive
    private BigDecimal loanAmount;

    @Positive
    private Double interestRate;

    @Positive
    private Integer tenureMonths;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @CreationTimestamp
    private LocalDateTime appliedAt;
}
