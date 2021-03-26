package com.hh99_spring.week01.controller;

import com.hh99_spring.week01.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/persons")
    public Person getPerson(){
        Person person = new Person();
        person.setName("정석진");
        person.setAge("27");
        person.setEmail("strong1133@naver.com");
        return person;
    }
}
