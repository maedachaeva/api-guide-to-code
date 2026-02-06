package com.demo.statistics.service;

import com.demo.statistics.dto.res.YearLoginCount;
import com.demo.statistics.dto.res.YearMonthLoginCount;
import com.demo.statistics.mapper.StatisticMapper;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private final StatisticMapper statisticMapper;

    public StatisticService(StatisticMapper statisticMapper) {
        this.statisticMapper = statisticMapper;
    }
    public YearLoginCount getYearLogins(String year) {
        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthLoginCount getYearMonthLogins(String year, String month) {
        String paddedMonth = month.length() == 1 ? "0" + month : month;
        return statisticMapper.selectYearMonthLogin(year + paddedMonth);
        }
}
