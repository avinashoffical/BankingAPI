package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.CreateCustomerRequest;
import com.avinash.BankingAPI.dto.request.UpdateCustomerRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.CustomerDTO;
import com.avinash.BankingAPI.entity.Customer;
import com.avinash.BankingAPI.entity.enums.AccountStatus;
import com.avinash.BankingAPI.repository.CustomerRepository;
import com.avinash.BankingAPI.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

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
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public CustomerDTO createCustomers(CreateCustomerRequest createCustomerRequest) throws Exception {
        if(customerRepository.existsByEmail(createCustomerRequest.getEmail())){
            throw new RuntimeException("Customer already exists with email :" +createCustomerRequest.getEmail());
        }
        Customer customer = modelMapper.map(createCustomerRequest,Customer.class);
        customer.setAccountStatus(AccountStatus.ACTIVE);
        customer.setAccountType(createCustomerRequest.getAccountType());
        return modelMapper.map(customerRepository.save(customer),CustomerDTO.class);
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
