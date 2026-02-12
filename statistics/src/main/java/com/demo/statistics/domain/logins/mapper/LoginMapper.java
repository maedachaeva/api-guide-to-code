package com.demo.statistics.domain.logins.mapper;

import com.demo.statistics.domain.logins.dto.YearLoginCount;
import com.demo.statistics.domain.logins.dto.YearMonthLoginCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    YearLoginCount selectYearLogin(@Param("year") String year);
    YearMonthLoginCount selectYearMonthLogin(@Param("yearMonth") String yearMonth);
}
