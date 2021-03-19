package com.hh99_spring.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Person extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int age;

    public Person(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.email= personRequestDto.getEmail();
        this.age = personRequestDto.getAge();
    }

    public void update(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.email= personRequestDto.getEmail();
        this.age = personRequestDto.getAge();
    }

}
