package com.avinash.BankingAPI.dto.response;

import lombok.Data;

@Data
public class BeneficiaryDTO {
    private Long beneficiaryId;

    private String nickname;

    private String accountHolderName;

    private String accountNumber;

    private String ifscCode;

    private String bankName;
}
