package com.laurastasiule.app.service;

import com.laurastasiule.app.domain.CountryWeeklyData;
import com.laurastasiule.app.dto.AllCaseDeathWeekDto;
import com.laurastasiule.app.dto.CaseDeathWeekDto;
import com.laurastasiule.app.repository.CountryWeeklyDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryWeeklyDataService {
    private final CountryWeeklyDataRepository repository;

    public CountryWeeklyDataService(CountryWeeklyDataRepository repository) {
        this.repository = repository;
    }

    public Iterable<CountryWeeklyData> getAll() {
        return repository.findAll();
    }

    public CountryWeeklyData save(CountryWeeklyData data ) {
        return repository.save(data);
    }

    public Iterable <CountryWeeklyData> save(List<CountryWeeklyData> allData) {
        return repository.saveAll(allData);
    }

    public List<String> getAllCountries() {
        return repository.findALlCountries();
    }

    public CaseDeathWeekDto getChartData(String country) {
        var cdw = new CaseDeathWeekDto();
        cdw.setYear_weeks(repository.getAllYearWeeks(country));
        cdw.setCasesPerWeek(repository.getAllCasesPerWeek(country));
        cdw.setDeathsPerWeek(repository.getAllDeathsPerWeek(country));
        return cdw;
    }

    public AllCaseDeathWeekDto getAllChartData() {
        var acdw = new AllCaseDeathWeekDto();
        acdw.setYear_weeks(repository.getAllYearWeeks());
        acdw.setCasesPerWeek(repository.getAllCasesPerWeek());
        acdw.setDeathsPerWeek(repository.getAllDeathsPerWeek());
        return acdw;
    }
}
