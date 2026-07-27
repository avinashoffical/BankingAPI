package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.CreateCustomerRequest;
import com.avinash.BankingAPI.dto.request.UpdateCustomerRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.CustomerDTO;
import com.avinash.BankingAPI.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<CustomerDTO> getLoggedInCustomer(){
        return new ResponseEntity<>(customerService.getLoggedInCustomer(),HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) throws Exception {
        return new ResponseEntity<>(customerService.createCustomers(createCustomerRequest),HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<CustomerDTO> updateLoggedInCustomer(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return new ResponseEntity<>(customerService.updateLoggedInCustomer(updateCustomerRequest),HttpStatus.OK);
    }

    @PutMapping("/{customerId}/block")
    public ResponseEntity<APIResponse> blockCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(customerService.blockCustomer(customerId),HttpStatus.OK);
    }

    @PutMapping("/{customerId}/unblock")
    public ResponseEntity<APIResponse> unblockCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(customerService.unblockCustomer(customerId),HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<APIResponse> deleteCustomer(@PathVariable Long customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
    }
}
