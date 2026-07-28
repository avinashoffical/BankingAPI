package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.enums.LoanType;
import com.avinash.BankingAPI.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

//    @ManyToOne
//    @JoinColumn(name = "transaction_id")
//    private Transaction transaction;
}
