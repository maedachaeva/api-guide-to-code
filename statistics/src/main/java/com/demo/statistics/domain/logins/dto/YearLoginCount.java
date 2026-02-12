package com.demo.statistics.domain.logins.dto;

public class YearLoginCount {
    private String year;
    private int totCnt;

    public YearLoginCount() {}

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }
}
