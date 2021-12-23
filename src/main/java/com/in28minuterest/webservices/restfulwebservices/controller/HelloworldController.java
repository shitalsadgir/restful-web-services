package com.in28minuterest.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloworldController {
    @Autowired
private MessageSource messageSource;
    //Get method two types
    //@RequestMapping(method = RequestMethod.GET,path = "hello-world")
    @GetMapping(path = "hello-world")
    public String helloworld(){
        return "Hello-World shital";
    }
    HelloWorldBean helloWorldBean=new HelloWorldBean("Hello Shital");
    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return helloWorldBean;
    }
    //HelloWorldBean helloWorldBean=new HelloWorldBean("Hello Shital");
    @GetMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloworldBeanPathVar(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello Shital, %s",name));
    }


    @GetMapping(path = "hello-world-international")
    public String helloworldInternational(@RequestHeader (name = "Accept-Language", required = false)Locale locale){

        return messageSource.getMessage("good.morning.message",null,locale);
    }


}
