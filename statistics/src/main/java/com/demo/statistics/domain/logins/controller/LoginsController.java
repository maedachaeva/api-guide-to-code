package com.demo.statistics.domain.logins.controller;

import com.demo.statistics.domain.logins.dto.YearLoginCount;
import com.demo.statistics.domain.logins.dto.YearMonthLoginCount;
import com.demo.statistics.domain.logins.service.LoginsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginsController {

    private final LoginsService loginsService;

    public LoginsController(LoginsService loginsService) {
        this.loginsService = loginsService;
    }

    @GetMapping(value = "/api/v1/logins/{year}", produces = "application/json")
    public ResponseEntity<YearLoginCount> getYearLoginCount(@PathVariable String year) {
        return ResponseEntity.ok(loginsService.getYearLogins(year));
    }

    @GetMapping(value = "/api/v1/logins/{year}/{month}", produces = "application/json")
    public ResponseEntity<YearMonthLoginCount> getYearMonthLoginCount(
            @PathVariable String year,
            @PathVariable String month
    ) {
        return ResponseEntity.ok(loginsService.getYearMonthLogins(year, month));
    }
}
