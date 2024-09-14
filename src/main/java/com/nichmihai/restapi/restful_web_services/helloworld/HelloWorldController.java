package com.nichmihai.restapi.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable("name") String str) {
        return new HelloWorldBean(String.format("Hello World, %s!", str));
    }


}
