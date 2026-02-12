package com.demo.statistics.domain.logins.dto;

public record WeekdayLoginStat(
        String fromDate,
        String toDate,
        Integer loginCount
) {}
