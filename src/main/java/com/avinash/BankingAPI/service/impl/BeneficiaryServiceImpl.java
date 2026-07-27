package com.avinash.BankingAPI.service.impl;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.request.UpdateBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import com.avinash.BankingAPI.entity.Beneficiary;
import com.avinash.BankingAPI.entity.Customer;
import com.avinash.BankingAPI.entity.User;
import com.avinash.BankingAPI.exception.CustomerNotFoundException;
import com.avinash.BankingAPI.exception.DuplicateResourceException;
import com.avinash.BankingAPI.exception.ResourceNotFoundException;
import com.avinash.BankingAPI.repository.BeneficiaryRepository;
import com.avinash.BankingAPI.repository.CustomerRepository;
import com.avinash.BankingAPI.repository.UserRepository;
import com.avinash.BankingAPI.service.BeneficiaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiaryServiceImpl implements BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BeneficiaryDTO> getMyBeneficiary() {
        Customer loggedInCustomer = getLoggedInCustomer();
        return beneficiaryRepository.findByCustomerId(loggedInCustomer.getCustomerId())
                .stream()
                .map(beneficiaries -> modelMapper.map(beneficiaries, BeneficiaryDTO.class))
                .toList();
    }

    @Override
    public BeneficiaryDTO getBeneficiaryById(Long beneficiaryId) throws AccessDeniedException {
        Customer loggedInCustomer = getLoggedInCustomer();
        Beneficiary beneficiary = verifyBeneficiaryId(beneficiaryId);
        if(!beneficiary.getCustomer().getCustomerId().equals(loggedInCustomer.getCustomerId())) {
            throw new AccessDeniedException("You do not have permission to access this beneficiary");
        }
        return modelMapper.map(beneficiary, BeneficiaryDTO.class);
    }

    @Override
    public BeneficiaryDTO addBeneficiary(AddBeneficiaryRequest addBeneficiaryRequest) throws DuplicateResourceException {
        Customer loggedInCustomer = getLoggedInCustomer();
        if(beneficiaryRepository.existsByAccountNumberAndIfscCodeAndCustomerId(
                addBeneficiaryRequest.getAccountNumber(),
                addBeneficiaryRequest.getIfscCode(),
                loggedInCustomer.getCustomerId())) {
            throw new DuplicateResourceException("Beneficiary already exists");
        }
        Beneficiary addedbeneficiary = modelMapper.map(addBeneficiaryRequest, Beneficiary.class);
        return modelMapper.map(beneficiaryRepository.save(addedbeneficiary), BeneficiaryDTO.class);
    }

    @Override
    public BeneficiaryDTO updateBeneficiary(Long beneficiaryId,UpdateBeneficiaryRequest updateBeneficiaryRequest) throws AccessDeniedException {
        Customer loggedInCustomer = getLoggedInCustomer();
        Beneficiary beneficiary = verifyBeneficiaryId(beneficiaryId);
        if(!beneficiary.getCustomer().getCustomerId().equals(loggedInCustomer.getCustomerId())) {
            throw new AccessDeniedException("You do not have permission to access this beneficiary");
        }
        Beneficiary updatedbeneficiary = modelMapper.map(updateBeneficiaryRequest, Beneficiary.class);
        return modelMapper.map(beneficiaryRepository.save(updatedbeneficiary), BeneficiaryDTO.class);
    }

    @Override
    public APIResponse deleteBeneficiary(Long beneficiaryId) throws AccessDeniedException {
        Customer loggedInCustomer = getLoggedInCustomer();
        Beneficiary beneficiary = verifyBeneficiaryId(beneficiaryId);
        if(!beneficiary.getCustomer().getCustomerId().equals(loggedInCustomer.getCustomerId())) {
            throw new AccessDeniedException("You do not have permission to access this beneficiary");
        }
        beneficiaryRepository.delete(beneficiary);
        return APIResponse.builder()
                .success(true)
                .message("Beneficiary has been deleted")
                .timestamp(LocalDateTime.now())
                .build();
    }

    private Beneficiary verifyBeneficiaryId(Long beneficiaryId){
        return beneficiaryRepository.findById(beneficiaryId).orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found with id:"+beneficiaryId));
    }

    private Customer getLoggedInCustomer() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return customerRepository.findByUser(user).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }
}
