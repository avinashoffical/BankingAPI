package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.DepositRequest;
import com.avinash.BankingAPI.dto.request.TransferRequest;
import com.avinash.BankingAPI.dto.request.WithdrawRequest;
import com.avinash.BankingAPI.dto.response.TransactionDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getHistory();

    TransactionDTO getTransaction(Long transactionId);

    TransactionDTO getTransactionByReference(String referenceNumber);

    List<TransactionDTO> getStatement();

    TransactionDTO deposit(@Valid DepositRequest depositRequest);

    TransactionDTO withdraw(@Valid WithdrawRequest withdrawRequest);

    TransactionDTO transfer(@Valid TransferRequest transferRequest);
}
