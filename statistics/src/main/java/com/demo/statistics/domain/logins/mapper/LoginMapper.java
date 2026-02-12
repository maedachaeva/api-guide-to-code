package com.demo.statistics.domain.logins.mapper;

import com.demo.statistics.domain.logins.dto.DepartmentMonthlyLoginStat;
import com.demo.statistics.domain.logins.dto.LoginAvgStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {
    LoginAvgStat selectAverageDailyLogins(
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate
    );

    List<DepartmentMonthlyLoginStat> selectMonthlyLoginsByDepartment(
            @Param("fromMonth") String fromMonth,
            @Param("toMonth") String toMonth
    );

    Integer selectTotalLoginsExcludingHolidays(
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate
    );

    /*YearLoginCount selectYearLogin(@Param("year") String year);
    YearMonthLoginCount selectYearMonthLogin(@Param("yearMonth") String yearMonth);*/
}
