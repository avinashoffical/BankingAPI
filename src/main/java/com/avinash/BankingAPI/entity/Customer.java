package com.avinash.BankingAPI.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

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
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNumber;

    @NotBlank
    @Size(max = 250)
    private String address;

    @Pattern(regexp = "\\d{12}")
    private String aadhaarNumber;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]1")
    private String panNumber;

}
