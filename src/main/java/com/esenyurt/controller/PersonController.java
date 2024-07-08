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
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonViewService personViewService;
    @PostMapping("/save")
    public ResponseEntity<?> savePerson(@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.savePerson(person),HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List> fetchPersons()
    {
        List<Person> personList = new ArrayList<>();
        personList = personService.fetchPersons();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(personList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person)
    {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id)
    {
        personService.deletePersonById(id);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name)
    {
        return new ResponseEntity<>(personViewService.findByName(name),HttpStatus.OK);
    }

    @GetMapping("/findByFullName/{fullName}")
    public ResponseEntity<?> findByFullName(@PathVariable String fullName)
    {
        return new ResponseEntity<>(personViewService.findByFullName(fullName),HttpStatus.OK);
    }
}
