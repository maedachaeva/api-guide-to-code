package com.demo.statistics.domain.visitors.service;

import com.demo.statistics.domain.visitors.dto.VisitorStat;

import java.util.List;

public interface VisitorService {
    List<VisitorStat> getMonthlyVisitors(String fromMonth, String toMonth);
    List<VisitorStat> getDailyVisitors(String fromDate, String toDate);
}
