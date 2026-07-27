package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.CreateAccountRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.AccountDTO;
import com.avinash.BankingAPI.dto.response.BalanceResponse;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getMyAccount();

    AccountDTO getAccountById(Long accountId);

    AccountDTO getByAccountNumber(String accountNumber);

    BalanceResponse getBalance(String accountNumber);

    List<AccountDTO> getAllAccount();

    List<AccountDTO> getAccountOfCustomer();

    AccountDTO createAccount(Long customerId, CreateAccountRequest createAccountRequest);

    APIResponse closeAccount(Long accountId);

    APIResponse freezeAccount(Long accountId);

    APIResponse activateAccount(Long accountId);
}
