package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.LoanApplicationRequest;
import com.avinash.BankingAPI.dto.request.LoanRepaymentRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.EmiScheduleDTO;
import com.avinash.BankingAPI.dto.response.LoanDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface LoanService {
    List<LoanDTO> getMyLoan();

    LoanDTO getLoanByID(Long loanId);

    List<EmiScheduleDTO> getSchedule(Long loanId);

    List<LoanDTO> getAllLoan();

    LoanDTO applyLoan(@Valid LoanApplicationRequest loanApplicationRequest);

    LoanDTO repayLoan(Long loanId, @Valid LoanRepaymentRequest loanRepaymentRequest);

    APIResponse closeLoan(Long loanId);

    APIResponse approveLoan(Long loanId);

    APIResponse rejectLoan(Long loanId);
}
