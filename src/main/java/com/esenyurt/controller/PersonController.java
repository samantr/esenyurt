package com.esenyurt.controller;

import com.esenyurt.entity.Person;
import com.esenyurt.service.PersonService;
import com.esenyurt.service.PersonViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonViewService personViewService;
    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.createPerson(person),HttpStatus.CREATED);
    }
    @GetMapping("/person")
    public ResponseEntity<List> readPersons()
    {
        List<Person> personList = new ArrayList<>();
        personList = personService.readPersons();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(personList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person)
    {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id)
    {
        personService.deletePersonById(id);
    }

    @GetMapping("/person/by-name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name)
    {
        return new ResponseEntity<>(personViewService.findByName(name),HttpStatus.OK);
    }

    @GetMapping("/person/by-full-name/{fullName}")
    public ResponseEntity<?> findByFullName(@PathVariable String fullName)
    {
        return new ResponseEntity<>(personViewService.findByFullName(fullName),HttpStatus.OK);
    }
}
