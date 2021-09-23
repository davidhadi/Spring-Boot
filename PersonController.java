package com.example.adnetwork.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDAO personDao;

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Person person = new Person();
            person.setId(id);
            personDao.delete(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person successfully deleted!";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String create(String name, String email, String mobile, String city, String pass) {
        try {
            Person person = new Person();
            person.setName(name);
            person.setEmail(email);
            person.setMobile(mobile);
            person.setCity(city);
            person.setPass(pass);
            personDao.savePerson(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person successfully saved!";
    }
    @RequestMapping("/allPersons")
    @ResponseBody
    public List getAllPersons() {
        try {
            return personDao.getAllPersons();
        } catch (Exception ex) {
            return null;
        }
    }
}