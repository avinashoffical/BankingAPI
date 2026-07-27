package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface BeneficiaryService {
    List<BeneficiaryDTO> getMyBeneficiary();

    BeneficiaryDTO getBeneficiaryById(Long beneficiaryId);

    BeneficiaryDTO addBeneficiary(@Valid AddBeneficiaryRequest addBeneficiaryRequest);

    BeneficiaryDTO updateBeneficiary(Long beneficiaryId);

    APIResponse deleteBeneficiary(Long beneficiaryId);
}
