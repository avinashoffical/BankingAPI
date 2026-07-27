package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.LoanApplicationRequest;
import com.avinash.BankingAPI.dto.request.LoanRepaymentRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.EmiScheduleDTO;
import com.avinash.BankingAPI.dto.response.LoanDTO;
import com.avinash.BankingAPI.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/my")
    public ResponseEntity<List<LoanDTO>> getMyLoan() {
        return new ResponseEntity<>(loanService.getMyLoan(), HttpStatus.OK);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanDTO> getLoanByID(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.getLoanByID(loanId), HttpStatus.OK);
    }

    @GetMapping("/{loanId}/schedule")
    public ResponseEntity<List<EmiScheduleDTO>> getSchedule(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.getSchedule(loanId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoan() {
        return new ResponseEntity<>(loanService.getAllLoan(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoanDTO> applyLoan(@Valid @RequestBody LoanApplicationRequest  loanApplicationRequest) {
        return new ResponseEntity<>(loanService.applyLoan(loanApplicationRequest), HttpStatus.OK);
    }

    @PostMapping("/{loanId}/repay")
    public ResponseEntity<LoanDTO> repayLoan(@PathVariable Long loanId, @Valid @RequestBody LoanRepaymentRequest loanRepaymentRequest) {
        return new ResponseEntity<>(loanService.repayLoan(loanId,loanRepaymentRequest), HttpStatus.OK);
    }

    @PutMapping("/{loanId}/close")
    public ResponseEntity<APIResponse> closeLoan(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.closeLoan(loanId), HttpStatus.OK);
    }

    @PutMapping("/{loanId}/approve")
    public ResponseEntity<APIResponse> approveLoan(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.approveLoan(loanId), HttpStatus.OK);
    }

    @PutMapping("/{loanId}/reject")
    public ResponseEntity<APIResponse> rejectLoan(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.rejectLoan(loanId), HttpStatus.OK);
    }
}
