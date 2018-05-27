package com.teamtreehouse.countryflags.data;


import com.teamtreehouse.countryflags.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
public class CountryRepository{
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("India", 1324000000, "New Delhi", Arrays.asList("Hindi", "English", "Bengali", "Telugu", "Marathi", "Tamil", "Urdu")),
            new Country("Kenya", 48460000, "Nairobi", Arrays.asList("Hindi", "Swahili", "Kikuyu", "Luhya", "Luo")),
            new Country("Ecuador", 16390000, "Quito", Arrays.asList("Spanish")),
            new Country("France", 66900000, "Paris", Arrays.asList("French")),
            new Country("Italy", 60600000, "Rome", Arrays.asList("Italian"))
    );

    public List<Country> getAllCountries() {return ALL_COUNTRIES; }

    public Country findByName(String name){
        for(Country country : ALL_COUNTRIES){
            if(country.getName().equals(name))
            {
                return country;
            }
        }
        return null;
    }

    // https://blog.jooq.org/2014/01/31/java-8-friday-goodies-lambdas-and-sorting/
    public List<Country> sortByName(List<Country> ALL_COUNTRIES){
//        ALL_COUNTRIES.sort(new Comparator<Country>() {
//            @Override
//            public int compare(Country o1, Country o2) {
//                int result = o1.getName().compareTo(o2.getName());
//                return result;
//            }
//        });
//        return ALL_COUNTRIES;

        Comparator<Country> c = (o1, o2) ->
                o1.getName().compareTo(o2.getName());
        ALL_COUNTRIES.sort(c);
        return ALL_COUNTRIES;
    }

    public List<Country> sortByPopulation(List<Country> ALL_COUNTRIES){
//        ALL_COUNTRIES.sort(new Comparator<Country>() {
//            @Override
//            public int compare(Country o1, Country o2) {
//                int result = Integer.valueOf(o1.getPopulation()).compareTo(Integer.valueOf(o2.getPopulation()));
//                return result;
//            }
//        });
//        return ALL_COUNTRIES;

        Comparator<Country> c = (o1, o2) ->
                Integer.valueOf(o1.getPopulation()).compareTo(Integer.valueOf(o2.getPopulation()));
        ALL_COUNTRIES.sort(c);
        return ALL_COUNTRIES;
    }

}
