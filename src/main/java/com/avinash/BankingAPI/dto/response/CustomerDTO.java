package com.avinash.BankingAPI.dto.response;

import com.avinash.BankingAPI.entity.enums.AccountStatus;
import com.avinash.BankingAPI.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String address;

    private String aadhaarNumber;

    private String panNumber;

//    private String username;

    private String accountStatus;

    private String accountType;
}
