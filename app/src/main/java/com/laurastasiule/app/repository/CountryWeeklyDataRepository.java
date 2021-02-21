package com.laurastasiule.app.repository;

import com.laurastasiule.app.domain.CountryWeeklyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryWeeklyDataRepository extends JpaRepository<CountryWeeklyData, Long> {

    @Query("SELECT DISTINCT c.country FROM CountryWeeklyData c WHERE c.country NOT LIKE '%total%'")
    List<String> findALlCountries();

    @Query("SELECT DISTINCT c.year_week FROM CountryWeeklyData c WHERE c.country = :country")
    List<String> getAllYearWeeks(String country );

    @Query("SELECT c.weekly_count FROM CountryWeeklyData c WHERE c.country = :country AND c.indicator = 'cases'")
    List<Integer> getAllCasesPerWeek(String country);

    @Query("SELECT c.weekly_count FROM CountryWeeklyData c WHERE c.country = :country AND c.indicator = 'deaths'")
    List<Integer> getAllDeathsPerWeek(String country);

    @Query("SELECT DISTINCT c.year_week FROM CountryWeeklyData c")
    List<String> getAllYearWeeks();

    @Query("SELECT sum(c.weekly_count) " +
            "FROM CountryWeeklyData c " +
            "WHERE c.indicator = 'cases' " +
            "AND c.country LIKE '%total%' " +
            "AND c.country NOT LIKE '%EU/EEA%' " +
            "GROUP BY c.year_week")
    List<Integer> getAllCasesPerWeek();

    @Query("SELECT sum(c.weekly_count) " +
            "FROM CountryWeeklyData c " +
            "WHERE c.indicator = 'deaths' " +
            "AND c.country LIKE '%total%' " +
            "AND c.country NOT LIKE '%EU/EEA%' " +
            "GROUP BY c.year_week")
    List<Integer> getAllDeathsPerWeek();
}
