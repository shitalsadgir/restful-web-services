package com.in28minuterest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloworldController {

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
}
