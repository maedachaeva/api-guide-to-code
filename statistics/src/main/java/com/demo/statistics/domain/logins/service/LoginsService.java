package com.demo.statistics.domain.logins.service;

import com.demo.statistics.domain.logins.dto.res.YearLoginCount;
import com.demo.statistics.domain.logins.dto.res.YearMonthLoginCount;
import com.demo.statistics.domain.logins.mapper.LoginsMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginsService {

    private final LoginsMapper loginsMapper;

    public LoginsService(LoginsMapper loginsMapper) {
        this.loginsMapper = loginsMapper;
    }
    public YearLoginCount getYearLogins(String year) {
        return loginsMapper.selectYearLogin(year);
    }

    public YearMonthLoginCount getYearMonthLogins(String year, String month) {
        String paddedMonth = month.length() == 1 ? "0" + month : month;
        return loginsMapper.selectYearMonthLogin(year + paddedMonth);
        }
}
