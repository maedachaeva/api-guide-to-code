package com.demo.statistics.domain.visitors.controller;

import com.demo.statistics.domain.visitors.dto.VisitorStat;
import com.demo.statistics.domain.visitors.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    // MAU
    @GetMapping("/api/v1/visitors/monthly")
    public List<VisitorStat> getMonthlyVisitors(
            @RequestParam String fromMonth,
            @RequestParam String toMonth) {
        return visitorService.getMonthlyVisitors(fromMonth, toMonth);
    }

    // DAU
    @GetMapping("/api/v1/visitors/daily")
    public List<VisitorStat> getDailyVisitors(
            @RequestParam String fromDate,
            @RequestParam String toDate) {
        return visitorService.getDailyVisitors(fromDate, toDate);
    }
}
