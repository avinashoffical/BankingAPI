package com.avinash.BankingAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "beneficiaries")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficiaryId;

    @NotBlank
    @Size(min = 2, max = 20)
    private String nickName;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private String accountHolderName;

    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$")
    private String ifscCode;

    @NotBlank
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
