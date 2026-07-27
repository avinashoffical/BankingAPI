package com.avinash.BankingAPI.repository;

import com.avinash.BankingAPI.entity.Beneficiary;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    boolean existsByAccountNumberAndIfscCode(String accountNumber, String ifscCode);

    Collection<Object> findByCustomerId(Long customerId);

    boolean existsByAccountNumberAndIfscCodeAndCustomerId(String accountNumber, String ifscCode, Long customerId);
}
