package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.request.UpdateBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import com.avinash.BankingAPI.exception.DuplicateResourceException;
import jakarta.validation.Valid;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface BeneficiaryService {
    List<BeneficiaryDTO> getMyBeneficiary();

    BeneficiaryDTO getBeneficiaryById(Long beneficiaryId) throws AccessDeniedException;

    BeneficiaryDTO addBeneficiary(@Valid AddBeneficiaryRequest addBeneficiaryRequest) throws DuplicateResourceException;

    BeneficiaryDTO updateBeneficiary(Long beneficiaryId,UpdateBeneficiaryRequest updateBeneficiaryRequest) throws AccessDeniedException;

    APIResponse deleteBeneficiary(Long beneficiaryId) throws AccessDeniedException;
}
