package com.demo.statistics.controller;

import com.demo.statistics.dto.res.YearLoginCount;
import com.demo.statistics.dto.res.YearMonthLoginCount;
import com.demo.statistics.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/api/v1/logins/{year}", produces = "application/json")
    public ResponseEntity<YearLoginCount> getYearLoginCount(@PathVariable String year) {
        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @GetMapping(value = "/api/v1/logins/{year}/{month}", produces = "application/json")
    public ResponseEntity<YearMonthLoginCount> getYearMonthLoginCount(
            @PathVariable String year,
            @PathVariable String month
    ) {
        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }
}
