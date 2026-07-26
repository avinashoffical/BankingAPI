package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.LoanStatus;
import com.avinash.BankingAPI.entity.enums.LoanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "loans")
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
    private LoanType loanType;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @CreationTimestamp
    private LocalDateTime appliedAt;

//    private Customer customer;
}
