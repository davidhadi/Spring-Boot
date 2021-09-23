package com.example.adnetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private PersonDAO personDao;

    @GetMapping("/login")
    public String login(@RequestParam String mobile, @RequestParam String pass){
        try {
            Person person = new Person();
            person.setMobile(mobile);
            person.setPass(pass);
            personDao.login(person);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return "Moblie and password are same..";
    }
}
