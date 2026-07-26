package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.CreateAccountRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.AccountDTO;
import com.avinash.BankingAPI.dto.response.BalanceResponse;
import com.avinash.BankingAPI.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public List<AccountDTO> getMyAccount() {
        return List.of();
    }

    @Override
    public AccountDTO getAccount(Long accountId) {
        return null;
    }

    @Override
    public AccountDTO getByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public BalanceResponse getBalance(String accountNumber) {
        return null;
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        return List.of();
    }

    @Override
    public List<AccountDTO> getAccountOfCustomer() {
        return List.of();
    }

    @Override
    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {
        return null;
    }

    @Override
    public APIResponse closeAccount(Long accountId) {
        return null;
    }

    @Override
    public APIResponse freezeAccount(Long accountId) {
        return null;
    }

    @Override
    public APIResponse activateAccount(Long accountId) {
        return null;
    }
}
