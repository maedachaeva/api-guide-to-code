package com.demo.statistics.domain.visitors.mapper;

import com.demo.statistics.domain.visitors.dto.VisitorStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VisitorMapper {

    // MAU
    List<VisitorStat> selectMonthlyVisitors(
            @Param("fromMonth") String fromMonth,
            @Param("toMonth") String toMonth
    );

    // DAU
    List<VisitorStat> selectDailyVisitors(
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate
    );
}
