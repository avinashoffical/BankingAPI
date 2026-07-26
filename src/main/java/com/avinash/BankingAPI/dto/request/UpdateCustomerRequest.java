package com.avinash.BankingAPI.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp="^[6-9]\\d{9}$")
    private String mobileNumber;

    @Email
    private String email;

    @NotBlank
    private String address;
}
