package com.demo.statistics.mapper;

import com.demo.statistics.dto.res.YearLoginCount;
import com.demo.statistics.dto.res.YearMonthLoginCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StatisticMapper {
    YearLoginCount selectYearLogin(@Param("year") String year);
    YearMonthLoginCount selectYearMonthLogin(@Param("yearMonth") String yearMonth);
}
