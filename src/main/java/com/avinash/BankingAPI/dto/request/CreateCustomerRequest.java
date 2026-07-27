package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerRequest {
    private String firstName;

    private String lastName;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String address;

    private String aadhaarNumber;

    private String panNumber;

}
