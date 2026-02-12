package com.demo.statistics.domain.visitors.service;

import com.demo.statistics.domain.visitors.dto.VisitorStat;
import com.demo.statistics.domain.visitors.mapper.VisitorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {
    private final VisitorMapper visitorMapper;

    @Override
    public List<VisitorStat> getMonthlyVisitors(String fromMonth, String toMonth) {
        return visitorMapper.selectMonthlyVisitors(fromMonth, toMonth);
    }

    @Override
    public List<VisitorStat> getDailyVisitors(String fromDate, String toDate) {
        return visitorMapper.selectDailyVisitors(fromDate, toDate);
    }
}
