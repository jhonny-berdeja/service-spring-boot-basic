package com.jberdeja.project_springboot_basic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.jberdeja.project_springboot_basic.dto.Person;

import lombok.extern.java.Log;

@Service
@Log
public class PersonService {

    private List<Person> persons = new ArrayList<>();

    public List<Person> getAll(){
        return persons;
    }

    public Person create(Person person) throws Exception{

        try{
            persons.add(person);
            return person;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
  
    }

    public Person update(Long dni, Person person) throws Exception{
        Optional<Person> personOfList = persons.stream().filter(p -> p.getDni().equals(dni)).findFirst();
        if(personOfList.isPresent()){
            int index = persons.indexOf(personOfList.get());
            persons.set(index, person);
            return person;
        }

        throw new Exception("Does not exist dni " + dni);
    }

    public Person delete(Long dni) throws Exception{
        log.info("DNI: " + dni);
        Optional<Person> person = persons.stream().filter(p -> p.getDni().equals(dni)).findFirst();
        if(person.isPresent()){
            int index = persons.indexOf(person.get());
            persons.remove(index);
            return person.get();
        }
        
        throw new Exception("Does not exist dni " + dni);
    }

}
