package com.laurastasiule.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountryWeeklyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String country;
    private String country_code;
    private String continent;
    private long population;
    private String indicator;
    private int weekly_count;
    private String year_week;
    private int cumulative_count;
    private String source;
    private String rate_14_day;

    public CountryWeeklyData() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public int getWeekly_count() {
        return weekly_count;
    }

    public void setWeekly_count(int weekly_count) {
        this.weekly_count = weekly_count;
    }

    public String getYear_week() {
        return year_week;
    }

    public void setYear_week(String year_week) {
        this.year_week = year_week;
    }

    public int getCumulative_count() {
        return cumulative_count;
    }

    public void setCumulative_count(int cumulative_count) {
        this.cumulative_count = cumulative_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRate_14_day() {
        return rate_14_day;
    }

    public void setRate_14_day(String rate_14_day) {
        this.rate_14_day = rate_14_day;
    }
}
