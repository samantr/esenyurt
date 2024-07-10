package com.esenyurt.service;

import com.esenyurt.entity.Person;
import com.esenyurt.enums.ErrorMessages;
import com.esenyurt.exception.ApplicationException;
import com.esenyurt.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {

        if (personRepository.findById(person.getId()).isPresent())
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), ErrorMessages.OBJECT_ALREADY_EXISTS.getTitle(), HttpStatus.BAD_REQUEST);

        try
        {
            return personRepository.save(person);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }


    public List<Person> readPersons() {

        try {
            return personRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }


    public Person updatePerson(Person person) {

        Optional<Person> personOptional = personRepository.findById(person.getId());

        if(person.getId() == null || !personOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);


        return personRepository.save(person);
    }


    public void deletePersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(!personOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        personRepository.deleteById(id);
    }

}
