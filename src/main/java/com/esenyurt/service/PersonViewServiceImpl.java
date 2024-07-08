package com.esenyurt.service;

import com.esenyurt.entity.Person;
import com.esenyurt.repository.PersonViewRepository;
import com.esenyurt.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonViewServiceImpl implements PersonViewService {

    @Autowired
    private PersonViewRepository personViewRepository;
    public List<PersonView> findByName(String name)
    {
        return personViewRepository.findByName(name);
    }
    public List<PersonView> findByFullName(String fullName)
    {
        return personViewRepository.findByFullName(fullName);
    }
}
