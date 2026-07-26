package com.avinash.BankingAPI.repository;

import com.avinash.BankingAPI.entity.Account;
import com.avinash.BankingAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
