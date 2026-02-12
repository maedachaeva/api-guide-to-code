package com.demo.statistics.domain.logins.service;

import com.demo.statistics.domain.logins.dto.LoginAvgStat;

public interface LoginService {
    LoginAvgStat getAverageDailyLogins(String fromDate, String toDate);

    /*YearLoginCount getYearLogins(String year);
    YearMonthLoginCount getYearMonthLogins(String year, String month);*/
}
