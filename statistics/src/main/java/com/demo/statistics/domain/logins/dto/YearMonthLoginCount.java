package com.demo.statistics.domain.logins.dto;

public class YearMonthLoginCount {
    private String yearMonth;
    private int totCnt;

    public YearMonthLoginCount() {}

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }
}
