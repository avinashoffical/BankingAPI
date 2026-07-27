package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.PaymentMethod;
import com.avinash.BankingAPI.entity.enums.TransactionStatus;
import com.avinash.BankingAPI.entity.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(unique = true)
    private String referenceNumber;

    @Positive
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod  paymentMethod;

    private String senderAccountNumber;

    private String recipientAccountNumber;

    @Size(min = 2, max = 200)
    private String remarks;

    @CreationTimestamp
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
}
