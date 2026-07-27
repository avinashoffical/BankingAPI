package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.LoanType;
import com.avinash.BankingAPI.entity.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "loan_payment")
public class LoanPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private LoanType loanType;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private PaymentMethod paymentMethod;

    private BigInteger transactionReference;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
