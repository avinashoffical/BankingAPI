package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.DepositRequest;
import com.avinash.BankingAPI.dto.request.TransferRequest;
import com.avinash.BankingAPI.dto.request.WithdrawRequest;
import com.avinash.BankingAPI.dto.response.TransactionDTO;
import com.avinash.BankingAPI.service.TransactionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Transactional
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/history")
    public ResponseEntity<List<TransactionDTO>> getHistory() {
        return new ResponseEntity<>(transactionService.getHistory(), HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long transactionId) {
        return new ResponseEntity<>(transactionService.getTransaction(transactionId), HttpStatus.OK);
    }

    @GetMapping("/reference/{referenceNumber}")
    public ResponseEntity<TransactionDTO> getByReference(@PathVariable String referenceNumber) {
        return new ResponseEntity<>(transactionService.getByReference(referenceNumber), HttpStatus.OK);
    }

    @GetMapping("/statement")
    public ResponseEntity<List<TransactionDTO>> getStatement() {
        return new ResponseEntity<>(transactionService.getStatement(), HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> deposit(@Valid @RequestBody DepositRequest depositRequest) {
        return new ResponseEntity<>(transactionService.deposit(depositRequest), HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@Valid @RequestBody WithdrawRequest withdrawRequest) {
        return new ResponseEntity<>(transactionService.withdraw(withdrawRequest), HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> transfer(@Valid @RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>(transactionService.transfer(transferRequest), HttpStatus.OK);
    }
}
