package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.DepositRequest;
import com.avinash.BankingAPI.dto.request.TransferRequest;
import com.avinash.BankingAPI.dto.request.WithdrawRequest;
import com.avinash.BankingAPI.dto.response.TransactionDTO;
import com.avinash.BankingAPI.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<TransactionDTO> getHistory() {
        return List.of();
    }

    @Override
    public TransactionDTO getTransaction(Long transactionId) {
        return null;
    }

    @Override
    public TransactionDTO getByReference(String referenceNumber) {
        return null;
    }

    @Override
    public List<TransactionDTO> getStatement() {
        return List.of();
    }

    @Override
    public TransactionDTO deposit(DepositRequest depositRequest) {
        return null;
    }

    @Override
    public TransactionDTO withdraw(WithdrawRequest withdrawRequest) {
        return null;
    }

    @Override
    public TransactionDTO transfer(TransferRequest transferRequest) {
        return null;
    }
}
