package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.LoanStatus;
import com.avinash.BankingAPI.entity.enums.LoanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

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
    private BigInteger loanNumber;

    @Positive
    private Double interestRate;

    @Positive
    private Integer tenureMonths;

    @Positive
    private Integer monthlyEMI;

    @Positive
    private BigDecimal remainingAmount;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @CreationTimestamp
    private LocalDateTime applicationDate;

    @CreationTimestamp
    private LocalDateTime approvedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "loan")
    private List<LoanPayment> loanPayments;
}
