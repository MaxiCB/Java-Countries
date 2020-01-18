package com.aaroncb.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController
{
    @GetMapping(value = "/names/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        JavaCountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getCountryName().compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesStartChar(@PathVariable char letter)
    {
        ArrayList<Country> rtnCnt = JavaCountriesApplication.countryList.
                findCountries(e -> e.getCountryName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCnt.sort((e1, e2) -> e1.getCountryName().compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }

    @GetMapping(value = "/names/size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesNameLength(@PathVariable int length)
    {
        ArrayList<Country> rtnCnt = JavaCountriesApplication.countryList.
                findCountries(e -> e.getCountryName().length() >= length);
        rtnCnt.sort((e1, e2) -> e1.getCountryName().compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }

    @GetMapping(value = "/population/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesPeopleLength(@PathVariable int length)
    {
        ArrayList<Country> rtnCnt = JavaCountriesApplication.countryList.
                findCountries(e -> e.getPopulation() >= length);
        rtnCnt.sort((e1, e2) -> e1.getCountryName().compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }

    @GetMapping(value = "/population/min",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesSmallestPopulation()
    {
        JavaCountriesApplication.countryList.countryList.sort((v1, v2) -> Integer.compare(v1.getPopulation(), v2.getPopulation()));

        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesBiggestPopulation()
    {
        JavaCountriesApplication.countryList.countryList.sort((v1, v2) -> Integer.compare(v2.getPopulation(), v1.getPopulation()));

        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/population/median",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesPopulationMedian()
    {
        JavaCountriesApplication.countryList.countryList.sort((v1, v2) -> Integer.compare(v2.getMedianAge(), v1.getMedianAge()));
        int count = JavaCountriesApplication.countryList.countryList.size();
        int index = count % 2;
        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList.get(count % 2 == 0 ? count : count + 1), HttpStatus.OK);
    }

    @GetMapping(value = "/age/age/{age}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianAge(@PathVariable int age)
    {
        ArrayList<Country> rtnCnt = JavaCountriesApplication.countryList.
                findCountries(e -> e.getMedianAge() >= age);
        rtnCnt.sort((e1, e2) -> e1.getCountryName().compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }

    @GetMapping(value = "/age/min",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryMinAge()
    {
        JavaCountriesApplication.countryList.countryList.sort((v1, v2) -> Integer.compare(v1.getMedianAge(), v2.getMedianAge()));

        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/age/max",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxAge()
    {
        JavaCountriesApplication.countryList.countryList.sort((v1, v2) -> Integer.compare(v2.getMedianAge(), v1.getMedianAge()));

        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }
}
