package com.hh99_spring.week02.controller;

import com.hh99_spring.week02.domain.Person;
import com.hh99_spring.week02.domain.PersonRepository;
import com.hh99_spring.week02.domain.PersonRequestDto;
import com.hh99_spring.week02.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }
    @PostMapping("/persons")
    public Person createPerson(@RequestBody PersonRequestDto personRequestDto){
        Person person = new Person(personRequestDto);
        return personRepository.save(person);
    }
    @PutMapping("/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto){
        return personService.update(id, personRequestDto);
    }

    @DeleteMapping("/persons/{id}")
    public Long updatePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }
}
