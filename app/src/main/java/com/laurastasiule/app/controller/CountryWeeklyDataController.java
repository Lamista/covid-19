package com.laurastasiule.app.controller;

import com.laurastasiule.app.domain.CountryWeeklyData;
import com.laurastasiule.app.dto.AllCaseDeathWeekDto;
import com.laurastasiule.app.dto.CaseDeathWeekDto;
import com.laurastasiule.app.service.CountryWeeklyDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "data")
@RequestMapping("/api/data")
public class CountryWeeklyDataController {

    private final CountryWeeklyDataService service;

    public CountryWeeklyDataController(CountryWeeklyDataService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all data from database", notes = "Returns all database data")
    public Iterable<CountryWeeklyData> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/countries")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get countries", notes = "Returns list of country names")
    public List<String> getAllCountries() {
        return service.getAllCountries();
    }

    @GetMapping(path = "/{country}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get information of the country", notes = "Returns week, case and death lists of the country")
    public CaseDeathWeekDto getChartData(@PathVariable("country") String country) {return service.getChartData(country); }

    @GetMapping(path = "/all-countries")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get information of all countries", notes = "Returns week, case and death lists of all countries")
    public AllCaseDeathWeekDto getChartData() {return service.getAllChartData(); }
}
