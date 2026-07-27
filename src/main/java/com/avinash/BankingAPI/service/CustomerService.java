package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.request.CreateCustomerRequest;
import com.avinash.BankingAPI.dto.request.UpdateCustomerRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.CustomerDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    CustomerDTO getLoggedInCustomer();

    CustomerDTO getCustomerById(Long customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createCustomer(CreateCustomerRequest createCustomerRequest) throws Exception;

    CustomerDTO updateLoggedInCustomer(@Valid UpdateCustomerRequest updateCustomerRequest);

    APIResponse blockCustomer(Long customerId);

    APIResponse unblockCustomer(Long customerId);

    APIResponse deleteCustomer(Long customerId);

}
