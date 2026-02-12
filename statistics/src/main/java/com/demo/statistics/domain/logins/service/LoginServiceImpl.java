package com.demo.statistics.domain.logins.service;


import com.demo.statistics.domain.logins.dto.DepartmentMonthlyLoginStat;
import com.demo.statistics.domain.logins.dto.LoginAvgStat;
import com.demo.statistics.domain.logins.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;

    @Override
    public LoginAvgStat getAverageDailyLogins(String fromDate, String toDate) {
        return loginMapper.selectAverageDailyLogins(fromDate, toDate);
    }

    @Override
    public List<DepartmentMonthlyLoginStat> getMonthlyLoginsByDepartment(String fromMonth, String toMonth) {
        return loginMapper.selectMonthlyLoginsByDepartment(fromMonth, toMonth);
    }

    /*@Override
    public YearLoginCount getYearLogins(String year) {
        return loginMapper.selectYearLogin(year);
    }

    @Override
    public YearMonthLoginCount getYearMonthLogins(String year, String month) {
        String paddedMonth = month.length() == 1 ? "0" + month : month;
        return loginMapper.selectYearMonthLogin(year + paddedMonth);
    }*/
}
