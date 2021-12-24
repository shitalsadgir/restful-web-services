package com.in28minuterest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue someBean(){
        Somebean somebean= new Somebean("V1","V2","V3");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(somebean);
        mapping.setFilters(filters);
        return mapping;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue SomebeanList(){
        List<Somebean> somebeanList= Arrays.asList(new Somebean("V1","V2","V3"),new Somebean("V11","V22","V33"));
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(somebeanList);
        mapping.setFilters(filters);
        return mapping;
    }
}
