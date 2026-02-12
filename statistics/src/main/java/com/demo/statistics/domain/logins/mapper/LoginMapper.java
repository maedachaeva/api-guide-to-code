package com.demo.statistics.domain.logins.mapper;

import com.demo.statistics.domain.logins.dto.res.YearLoginCount;
import com.demo.statistics.domain.logins.dto.res.YearMonthLoginCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    YearLoginCount selectYearLogin(@Param("year") String year);
    YearMonthLoginCount selectYearMonthLogin(@Param("yearMonth") String yearMonth);
}
