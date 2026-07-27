package com.avinash.BankingAPI.util;

import com.avinash.BankingAPI.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AccountNumberGenerator {

    private final AccountRepository accountRepository;

    public String generateAccountNumber() {
        String accountNumber;
        do{
            accountNumber = generateRandomDigit();
        }while(accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }

    private String generateRandomDigit(){
        Long randomNumber = ThreadLocalRandom.current().nextLong(100000000L,999999999L);
        return "352" + randomNumber;
    }
}
