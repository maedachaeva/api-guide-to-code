package com.demo.statistics.domain.logins.dto;

public record DepartmentMonthlyLoginStat(
        String departmentId,
        String departmentName,
        String yearMonth,
        Integer loginCount
) {}
