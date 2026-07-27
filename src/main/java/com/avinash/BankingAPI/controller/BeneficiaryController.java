package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.request.UpdateBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import com.avinash.BankingAPI.exception.DuplicateResourceException;
import com.avinash.BankingAPI.service.BeneficiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
@RequiredArgsConstructor
public class BeneficiaryController {
    private final BeneficiaryService beneficiaryService;

    @GetMapping
    public ResponseEntity<List<BeneficiaryDTO>> getMyBeneficiary() {
        return new ResponseEntity<>(beneficiaryService.getMyBeneficiary(), HttpStatus.OK);
    }

    @GetMapping("/{beneficiaryId}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiaryById(@PathVariable Long beneficiaryId) throws AccessDeniedException {
        return new ResponseEntity<>(beneficiaryService.getBeneficiaryById(beneficiaryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeneficiaryDTO> addBeneficiary(@Valid @RequestBody AddBeneficiaryRequest addBeneficiaryRequest) throws DuplicateResourceException {
        return new ResponseEntity<>(beneficiaryService.addBeneficiary(addBeneficiaryRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{beneficiaryId}")
    public ResponseEntity<BeneficiaryDTO> updateBeneficiary(@PathVariable Long beneficiaryId,@Valid @RequestBody UpdateBeneficiaryRequest updateBeneficiaryRequest) throws AccessDeniedException {
        return new ResponseEntity<>(beneficiaryService.updateBeneficiary(beneficiaryId,updateBeneficiaryRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{beneficiaryId}")
    public ResponseEntity<APIResponse> deleteBeneficiary(@PathVariable Long beneficiaryId) throws AccessDeniedException {
        return new ResponseEntity<>(beneficiaryService.deleteBeneficiary(beneficiaryId), HttpStatus.OK);
    }
}
