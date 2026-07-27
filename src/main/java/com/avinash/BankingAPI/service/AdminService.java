package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.response.*;

import java.util.List;

public interface AdminService {
    DashboardDTO getDashboard();

    List<CustomerDTO> getALLCustomers();

    CustomerDTO getCustomerById(Long customerId);

    APIResponse blockCustomer(Long customerId);

    APIResponse unblockCustomer(Long customerId);

    Object getAllAccounts();

    List<TransactionDTO> getTransactions();

    TransactionDTO getTransactionById(Long transactionId);

    TransactionDTO getTransactionByReference(Long referenceNumber);

    DashboardStatisticsDTO getStatistics();

    LoanDTO getAllLoans();

    APIResponse freezeAccount(Long accountsId);

    APIResponse activateAccount(Long accountsId);

    APIResponse closeAccount(Long accountsId);

    APIResponse deleteCustomer(Long customerId);
}
