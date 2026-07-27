package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.CreateAccountRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.AccountDTO;
import com.avinash.BankingAPI.dto.response.BalanceResponse;
import com.avinash.BankingAPI.entity.Account;
import com.avinash.BankingAPI.entity.Customer;
import com.avinash.BankingAPI.entity.enums.AccountStatus;
import com.avinash.BankingAPI.repository.AccountRepository;
import com.avinash.BankingAPI.repository.CustomerRepository;
import com.avinash.BankingAPI.service.AccountService;
import com.avinash.BankingAPI.util.AccountNumberGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountNumberGenerator accountNumberGenerator;
    private final ModelMapper modelMapper;

    @Override
    public List<AccountDTO> getMyAccount() {
        return List.of();
    }

    @Override
    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found with account id:"+accountId));
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public AccountDTO getByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found with account number:"+accountNumber);
        }
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public BalanceResponse getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found with account number:"+accountNumber);
        }
        return BalanceResponse.builder()
                .accountNumber(accountNumber)
                .balance(account.getBalance())
                .build();
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty()) {
            throw new RuntimeException("Account not found");
        }
        return accounts.stream().map(account -> modelMapper.map(account,AccountDTO.class)).toList();
    }

    @Override
    public List<AccountDTO> getAccountOfCustomer(Long customerId) {
        return List.of();
    }

    @Transactional
    @Override
    public AccountDTO createAccount(Long customerId, CreateAccountRequest createAccountRequest) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id "+customerId));
        if(accountRepository.existsByCustomerAndAccountType(customer,createAccountRequest.getAccountType())){
            throw new RuntimeException("Account already exists");
        }

        Account account = new Account();
        account.setCustomer(customer);
        account.setStatus(AccountStatus.ACTIVE);
        account.setAccountNumber(accountNumberGenerator.generateAccountNumber());
        account.setAccountType(createAccountRequest.getAccountType());
        account.setBalance(createAccountRequest.getInitialDeposit());
//        account.setCreatedAt(LocalDateTime.now());

        return modelMapper.map(accountRepository.save(account), AccountDTO.class);
    }

    @Override
    public APIResponse closeAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found with id " + accountId));
        account.setStatus(AccountStatus.CLOSED);
        accountRepository.save(account);
        return APIResponse.builder()
                .success(true)
                .message("Account CLOSED")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public APIResponse freezeAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found with id " + accountId));
        account.setStatus(AccountStatus.FREEZE);
        accountRepository.save(account);
        return APIResponse.builder()
                .success(true)
                .message("Account FREEZE")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public APIResponse activateAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found with id " + accountId));
        account.setStatus(AccountStatus.ACTIVE);
        accountRepository.save(account);
        return APIResponse.builder()
                .success(true)
                .message("Account ACTIVATED")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
