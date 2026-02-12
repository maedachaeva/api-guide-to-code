package com.demo.statistics.domain.logins.service;

import com.demo.statistics.domain.logins.dto.YearLoginCount;
import com.demo.statistics.domain.logins.dto.YearMonthLoginCount;
import com.demo.statistics.domain.logins.mapper.LoginMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginsService {

    private final LoginMapper loginMapper;

    public LoginsService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }
    public YearLoginCount getYearLogins(String year) {
        return loginMapper.selectYearLogin(year);
    }

    public YearMonthLoginCount getYearMonthLogins(String year, String month) {
        String paddedMonth = month.length() == 1 ? "0" + month : month;
        return loginMapper.selectYearMonthLogin(year + paddedMonth);
        }
}
