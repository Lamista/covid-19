package com.laurastasiule.app.dto;

import java.util.List;

public class AllCaseDeathWeekDto {
    private List<String> year_weeks;
    private List<Integer> casesPerWeek;
    private List<Integer> deathsPerWeek;

    public AllCaseDeathWeekDto() {
    }

    public List<String> getYear_weeks() {
        return year_weeks;
    }

    public void setYear_weeks(List<String> year_weeks) {
        this.year_weeks = year_weeks;
    }

    public List<Integer> getCasesPerWeek() {
        return casesPerWeek;
    }

    public void setCasesPerWeek(List<Integer> casesPerWeek) {
        this.casesPerWeek = casesPerWeek;
    }

    public List<Integer> getDeathsPerWeek() {
        return deathsPerWeek;
    }

    public void setDeathsPerWeek(List<Integer> deathsPerWeek) {
        this.deathsPerWeek = deathsPerWeek;
    }
}
