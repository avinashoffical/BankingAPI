package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.response.*;
import com.avinash.BankingAPI.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public DashboardDTO getDashboard() {
        return null;
    }

    @Override
    public List<CustomerDTO> getALLCustomers() {
        return List.of();
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return null;
    }

    @Override
    public APIResponse blockCustomer(Long customerId) {
        return null;
    }

    @Override
    public APIResponse unblockCustomer(Long customerId) {
        return null;
    }

    @Override
    public Object getAllAccounts() {
        return null;
    }

    @Override
    public List<TransactionDTO> getTransactions() {
        return List.of();
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionByReference(Long referenceNumber) {
        return null;
    }

    @Override
    public DashboardStatisticsDTO getStatistics() {
        return null;
    }

    @Override
    public LoanDTO getAllLoans() {
        return null;
    }

    @Override
    public APIResponse freezeAccount(Long accountsId) {
        return null;
    }

    @Override
    public APIResponse activateAccount(Long accountsId) {
        return null;
    }

    @Override
    public APIResponse closeAccount(Long accountsId) {
        return null;
    }

    @Override
    public APIResponse deleteCustomer(Long customerId) {
        return null;
    }
}
