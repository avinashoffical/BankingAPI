package com.avinash.BankingAPI.repository;

import com.avinash.BankingAPI.entity.Account;
import com.avinash.BankingAPI.entity.Customer;
import com.avinash.BankingAPI.entity.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByAccountNumber(String accountNumber);

    Account findByAccountNumber(String accountNumber);

    boolean existsByCustomerAndAccountType(Customer customer, AccountType accountType);
}
