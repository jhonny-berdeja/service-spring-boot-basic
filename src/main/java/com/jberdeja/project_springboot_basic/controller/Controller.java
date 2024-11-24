package com.jberdeja.project_springboot_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jberdeja.project_springboot_basic.dto.Person;
import com.jberdeja.project_springboot_basic.service.PersonService;

import jakarta.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private PersonService personService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World!";
    }

    @GetMapping("/getall")
    public List<Person> getAllPeople() {
        return personService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Person person){
        try{
            return ResponseEntity.ok(personService.create(person));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update/{dni}")
    public ResponseEntity<?> update(@PathVariable Long dni, @RequestBody Person person){
        try{
            return ResponseEntity.ok(personService.update(dni, person));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<?> delete(@PathVariable Long dni){
        try{
            return ResponseEntity.ok(personService.delete(dni));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
