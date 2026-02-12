package com.demo.statistics.domain.login.controller;

import com.demo.statistics.domain.logins.dto.LoginAvgStat;
import com.demo.statistics.domain.logins.dto.YearLoginCount;
import com.demo.statistics.domain.logins.dto.YearMonthLoginCount;
import com.demo.statistics.domain.logins.service.LoginService;
import com.demo.statistics.global.common.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/logins")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/average-daily")
    public SuccessResponse<LoginAvgStat> getAverageDailyLogins(
            @RequestParam String fromDate,
            @RequestParam String toDate) {
        return new SuccessResponse<>(loginService.getAverageDailyLogins(fromDate, toDate));
    }

    /*@GetMapping("/{year}")
    public SuccessResponse<YearLoginCount> getYearLoginCount(@PathVariable String year) {
        return new SuccessResponse<>(loginService.getYearLogins(year));
    }

    @GetMapping("/{year}/{month}")
    public SuccessResponse<YearMonthLoginCount> getYearMonthLoginCount(
            @PathVariable String year,
            @PathVariable String month) {
        return new SuccessResponse<>(loginService.getYearMonthLogins(year, month));
    }*/
}
