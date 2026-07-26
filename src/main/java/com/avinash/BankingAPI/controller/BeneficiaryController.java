package com.avinash.BankingAPI.controller;

import com.avinash.BankingAPI.dto.request.AddBeneficiaryRequest;
import com.avinash.BankingAPI.dto.response.APIResponse;
import com.avinash.BankingAPI.dto.response.BeneficiaryDTO;
import com.avinash.BankingAPI.service.BeneficiaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping
    public ResponseEntity<List<BeneficiaryDTO>> getMyBeneficiary() {
        return new ResponseEntity<>(beneficiaryService.getMyBeneficiary(), HttpStatus.CREATED);
    }

    @GetMapping("/{beneficiaryId}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiaryById(@PathVariable Long beneficiaryId) {
        return new ResponseEntity<>(beneficiaryService.getBeneficiaryById(beneficiaryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeneficiaryDTO> addBeneficiary(@Valid @RequestBody AddBeneficiaryRequest addBeneficiaryRequest) {
        return new ResponseEntity<>(beneficiaryService.addBeneficiary(addBeneficiaryRequest), HttpStatus.OK);
    }

    @PutMapping("/{beneficiaryId}")
    public ResponseEntity<BeneficiaryDTO> updateBeneficiary(@PathVariable Long beneficiaryId) {
        return new ResponseEntity<>(beneficiaryService.updateBeneficiary(beneficiaryId), HttpStatus.OK);
    }

    @DeleteMapping("/{beneficiaryId}")
    public ResponseEntity<APIResponse> deleteBeneficiary(@PathVariable Long beneficiaryId) {
        return new ResponseEntity<>(beneficiaryService.deleteBeneficiary(beneficiaryId), HttpStatus.OK);
    }
}
