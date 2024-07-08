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
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person savePerson(Person person) {
        Person p = null;
        try
        {
            p = personRepository.save(person);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
        return p;
    }

    @Override
    public List<Person> fetchPersons() {

        try {
            return personRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Person updatePerson(Person person) {

        Optional<Person> p = personRepository.findById(person.getId());

        if(person.getId() == null || !p.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);


        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        Optional<Person> p = personRepository.findById(id);
        if(!p.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        personRepository.deleteById(id);
    }

}
