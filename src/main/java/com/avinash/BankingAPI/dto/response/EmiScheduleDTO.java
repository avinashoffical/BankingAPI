package com.avinash.BankingAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmiScheduleDTO {
    private Integer installmentNumber;

    private LocalDate dueDate;

    private BigDecimal emiAmount;

    private BigDecimal principalAmount;

    private BigDecimal interestAmount;

    private BigDecimal remainingBalance;
}
