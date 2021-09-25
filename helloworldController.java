package com.example.adnetwork;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {

    @RequestMapping("/hello")
    public String hello(@RequestParam String name, @RequestParam String pass){
        if(name.equals("shakil") && pass.equals("password"))
            return "you entered name and password is correct";
        else
            return "Opps! you entered name and password is incorrect";
    }
}