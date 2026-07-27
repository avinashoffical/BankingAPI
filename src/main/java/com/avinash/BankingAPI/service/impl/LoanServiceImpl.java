package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.LoanApplicationRequest;
import com.avinash.BankingAPI.dto.request.LoanRepaymentRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.EmiScheduleDTO;
import com.avinash.BankingAPI.dto.response.LoanDTO;
import com.avinash.BankingAPI.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Override
    public List<LoanDTO> getMyLoan() {
        return List.of();
    }

    @Override
    public LoanDTO getLoanByID(Long loanId) {
        return null;
    }

    @Override
    public List<EmiScheduleDTO> getSchedule(Long loanId) {
        return List.of();
    }

    @Override
    public List<LoanDTO> getAllLoan() {
        return List.of();
    }

    @Override
    public LoanDTO applyLoan(LoanApplicationRequest loanApplicationRequest) {
        return null;
    }

    @Override
    public LoanDTO repayLoan(Long loanId, LoanRepaymentRequest loanRepaymentRequest) {
        return null;
    }

    @Override
    public APIResponse closeLoan(Long loanId) {
        return null;
    }

    @Override
    public APIResponse approveLoan(Long loanId) {
        return null;
    }

    @Override
    public APIResponse rejectLoan(Long loanId) {
        return null;
    }
}
