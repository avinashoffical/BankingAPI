package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.CreateAccountRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.AccountDTO;
import com.avinash.BankingAPI.dto.response.BalanceResponse;
import com.avinash.BankingAPI.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/my")
    public ResponseEntity<List<AccountDTO>> getMyAccount() {
        return new ResponseEntity<>(accountService.getMyAccount(), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<AccountDTO> getByAccountNumber(@PathVariable String accountNumber) {
        return new ResponseEntity<>(accountService.getByAccountNumber(accountNumber), HttpStatus.OK);
    }

    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable String accountNumber) {
        return new ResponseEntity<>(accountService.getBalance(accountNumber), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccount() {
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountDTO>> getAccountOfCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(accountService.getAccountOfCustomer(), HttpStatus.OK);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<AccountDTO> createAccount(@PathVariable Long customerId,@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        return new ResponseEntity<>(accountService.createAccount(customerId,createAccountRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}/close")
    public ResponseEntity<APIResponse> closeAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.closeAccount(accountId),HttpStatus.OK);
    }

    @PutMapping("/{accountId}/freeze")
    public ResponseEntity<APIResponse> freezeAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.freezeAccount(accountId),HttpStatus.OK);
    }

    @PutMapping("/{accountId}/activate")
    public ResponseEntity<APIResponse> activateAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.activateAccount(accountId),HttpStatus.OK);
    }

}
