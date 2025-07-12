package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        country india = context.getBean("in", country.class);
        return india;
    }
    @GetMapping("/country/{code}")
    public country getCountry(@PathVariable String code){
        return countryService.getCountry(code);
    }
}
