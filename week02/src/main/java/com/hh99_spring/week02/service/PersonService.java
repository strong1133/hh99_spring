package com.hh99_spring.week02.service;

import com.hh99_spring.week02.domain.Person;
import com.hh99_spring.week02.domain.PersonRepository;
import com.hh99_spring.week02.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto personRequestDto){
        Person person = personRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        person.update(personRequestDto);
        return person.getId();
    }
}
