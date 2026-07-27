package com.avinash.BankingAPI.entity;

import com.avinash.BankingAPI.entity.enums.AccountStatus;
import com.avinash.BankingAPI.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @Size(min = 2, max = 50)
    private String lastName;

    @Email
    private String email;

    @Past
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

//    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNumber;

    @NotBlank
    @Size(max = 250)
    private String address;

//    @Pattern(regexp = "\\d{12}")
    private String aadhaarNumber;

//    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]$")
    private String panNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Beneficiary> beneficiaries;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;

}
