package com.demo.statistics.domain.visitors.controller;

import com.demo.statistics.domain.visitors.dto.VisitorStat;
import com.demo.statistics.domain.visitors.service.VisitorService;
import com.demo.statistics.global.common.response.SuccessResponse;
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
    public SuccessResponse<List<VisitorStat>> getMonthlyVisitors(
            @RequestParam String fromMonth,
            @RequestParam String toMonth) {
        return new SuccessResponse<>(visitorService.getMonthlyVisitors(fromMonth, toMonth));
    }

    // DAU
    @GetMapping("/api/v1/visitors/daily")
    public SuccessResponse<List<VisitorStat>> getDailyVisitors(
            @RequestParam String fromDate,
            @RequestParam String toDate) {
        return new SuccessResponse<>(visitorService.getDailyVisitors(fromDate, toDate));
    }
}
