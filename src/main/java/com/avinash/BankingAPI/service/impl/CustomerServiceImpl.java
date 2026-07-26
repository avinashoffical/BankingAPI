package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.UpdateCustomerRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.CustomerDTO;
import com.avinash.BankingAPI.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getLoggedInCustomer() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDTO updateLoggedInCustomer(UpdateCustomerRequest updateCustomerRequest) {
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
    public APIResponse deleteCustomer(Long customerId) {
        return null;
    }
}
