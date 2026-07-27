package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.CreateCustomerRequest;
import com.avinash.BankingAPI.dto.request.UpdateCustomerRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.CustomerDTO;
import com.avinash.BankingAPI.entity.Customer;
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
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
//        return modelMapper.map(customer, CustomerDTO.class);
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new RuntimeException("No customers found");
        }
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public CustomerDTO createCustomer(CreateCustomerRequest createCustomerRequest) {
        if(customerRepository.existsByEmail(createCustomerRequest.getEmail())){
            throw new RuntimeException("Customer already exists with email :" +createCustomerRequest.getEmail());
        }
        Customer customer = modelMapper.map(createCustomerRequest,Customer.class);
        return modelMapper.map(customerRepository.save(customer),CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateLoggedInCustomer(UpdateCustomerRequest updateCustomerRequest) {
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
//        customer.setFirstName(updateCustomerRequest.getFirstName());
//        customer.setLastName(updateCustomerRequest.getLastName());
//        customer.setEmail(updateCustomerRequest.getEmail());
//        customer.setAddress(updateCustomerRequest.getAddress());
//        customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
//        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
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
