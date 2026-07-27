package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.response.*;
import com.avinash.BankingAPI.service.AdminService;
import com.avinash.BankingAPI.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LoanService loanService;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> getDashboard(){
        return new ResponseEntity<>(adminService.getDashboard(), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getALLCustomers(){
        return new ResponseEntity<>(adminService.getALLCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId){
        return new ResponseEntity<>(adminService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PutMapping("/customers/{customerId}/block")
    public ResponseEntity<APIResponse> blockCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(adminService.blockCustomer(customerId), HttpStatus.OK);
    }

    @PutMapping("/customers/{customerId}/unblock")
    public ResponseEntity<APIResponse> unblockCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(adminService.unblockCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        return new ResponseEntity(adminService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactions(){
        return new ResponseEntity<>(adminService.getTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transactions/{transactionId}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long transactionId){
        return new ResponseEntity<>(adminService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @GetMapping("/transactions/reference/{referenceNumber}")
    public ResponseEntity<TransactionDTO> getTransactionByReference(@PathVariable Long referenceNumber){
        return new ResponseEntity<>(adminService.getTransactionByReference(referenceNumber), HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<DashboardStatisticsDTO> getStatistics(){
        return new ResponseEntity<>(adminService.getStatistics(), HttpStatus.OK);
    }

    @GetMapping("/loans")
    public ResponseEntity<LoanDTO> getAllLoans(){
        return new ResponseEntity<>(adminService.getAllLoans(), HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountsId}/freeze")
    public ResponseEntity<APIResponse> freezeAccount(@PathVariable Long accountsId){
        return new ResponseEntity<>(adminService.freezeAccount(accountsId), HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountsId}/activate")
    public ResponseEntity<APIResponse> activateAccount(@PathVariable Long accountsId){
        return new ResponseEntity<>(adminService.activateAccount(accountsId), HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountsId}/close")
    public ResponseEntity<APIResponse> closeAccount(@PathVariable Long accountsId){
        return new ResponseEntity<>(adminService.closeAccount(accountsId), HttpStatus.OK);
    }

    @PutMapping("/loans/{loanId}/approve")
    public ResponseEntity<APIResponse> approveLoan(@PathVariable Long loanId){
        return new ResponseEntity<>(loanService.approveLoan(loanId), HttpStatus.OK);
    }

    @PutMapping("/loans/{loanId}/reject")
    public ResponseEntity<APIResponse> rejectLoan(@PathVariable Long loanId){
        return new ResponseEntity<>(loanService.rejectLoan(loanId), HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<APIResponse> deleteCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(adminService.deleteCustomer(customerId), HttpStatus.OK);
    }
}
