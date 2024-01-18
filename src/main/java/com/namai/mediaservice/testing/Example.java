package com.namai.mediaservice.testing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class Example {

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello from spring";
    }
    
}
