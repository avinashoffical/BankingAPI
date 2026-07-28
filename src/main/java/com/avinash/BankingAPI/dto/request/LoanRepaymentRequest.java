package com.avinash.BankingAPI.dto.request;

import com.avinash.BankingAPI.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanRepaymentRequest {
    @NotNull(message = "Repayment amount is required")
    @DecimalMin(value = "1", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    @Size(max = 200)
    private String remarks;
}
