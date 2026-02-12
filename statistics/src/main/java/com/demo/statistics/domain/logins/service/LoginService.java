package com.demo.statistics.domain.logins.service;

import com.demo.statistics.domain.logins.dto.DepartmentMonthlyLoginStat;
import com.demo.statistics.domain.logins.dto.LoginAvgStat;

import java.util.List;

public interface LoginService {
    LoginAvgStat getAverageDailyLogins(String fromDate, String toDate);

    List<DepartmentMonthlyLoginStat> getMonthlyLoginsByDepartment(String fromMonth, String toMonth);

    /*YearLoginCount getYearLogins(String year);
    YearMonthLoginCount getYearMonthLogins(String year, String month);*/
}
