package com.hh99_spring.week01.domain;

public class Person {
    private  String name;
    private  String age;
    private  String email;



    public String getName() {
        return this.name;
    }
    public String getAge() {
        return this.age;
    }
    public String getEmail() {
        return this.email;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(String age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
