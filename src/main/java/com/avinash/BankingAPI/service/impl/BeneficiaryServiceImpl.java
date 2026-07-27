package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import com.avinash.BankingAPI.service.BeneficiaryService;
import com.avinash.BankingAPI.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
    @Override
    public List<BeneficiaryDTO> getMyBeneficiary() {
        return List.of();
    }

    @Override
    public BeneficiaryDTO getBeneficiaryById(Long beneficiaryId) {
        return null;
    }

    @Override
    public BeneficiaryDTO addBeneficiary(AddBeneficiaryRequest addBeneficiaryRequest) {
        return null;
    }

    @Override
    public BeneficiaryDTO updateBeneficiary(Long beneficiaryId) {
        return null;
    }

    @Override
    public APIResponse deleteBeneficiary(Long beneficiaryId) {
        return null;
    }
}
