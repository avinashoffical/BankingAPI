package com.avinash.BankingAPI.service;

import com.avinash.BankingAPI.dto.response.*;

public interface AdminService {
    DashboardDTO getDashboard();

    DashboardStatisticsDTO getStatistics();

}
