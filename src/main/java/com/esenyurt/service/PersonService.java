package com.esenyurt.service;

import com.esenyurt.entity.Person;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> fetchPersons();
    Person updatePerson(Person person);
    void deletePersonById(Long id);



}
