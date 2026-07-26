package com.avinash.BankingAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardStatisticsDTO {
    private Long totalCustomers;
    private Long activeCustomers;
    private Long blockedCustomers;

    private Long totalAccounts;
    private Long activeAccounts;
    private Long blockedAccounts;
    private Long closedAccounts;

    private Long totalTransactions;
    private Long todayTransactions;

    private BigDecimal totalDeposits;
    private BigDecimal totalWithdrawals;
    private BigDecimal totalTransfers;

    private BigDecimal todayDeposits;
    private BigDecimal todayWithdrawals;
    private BigDecimal todayTransfers;

    private BigDecimal totalBankBalance;

    private Long totalLoans;
    private Long approvedLoans;
    private Long pendingLoans;
    private Long rejectedLoans;
}
