package com.in28minuterest.webservices.restfulwebservices.versoning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("Shital sadgir");
    }
    @GetMapping("/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("Shital"," sadgir"));
    }
}
