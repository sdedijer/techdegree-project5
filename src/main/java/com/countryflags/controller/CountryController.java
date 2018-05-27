package com.countryflags.controller;

import com.countryflags.data.*;
import com.countryflags.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap){
        List<Country> countryList = countryRepository.getAllCountries();
        modelMap.put("countries", countryList);
        return "index";
    }

    @RequestMapping("/namesorting")
    public String listCountriesSortedByName(ModelMap modelMap){
        List<Country> countryList = countryRepository.getAllCountries();
        List<Country> sortedList = countryRepository.sortByName(countryList);
        modelMap.put("countries", sortedList);
//        return "redirect:/";
        return "index";
    }

    @RequestMapping("/populationsorting")
    public String listCountriesSortedByPopulation(ModelMap modelMap){
        List<Country> countryList = countryRepository.getAllCountries();
        List<Country> sortedList = countryRepository.sortByPopulation(countryList);
        modelMap.put("countries", sortedList);
//        return "redirect:/";
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String country(@PathVariable String name, ModelMap modelMap){
        Country countryPassed = countryRepository.findByName(name);
        modelMap.put("country", countryPassed);
        return "detail";
    }

}
