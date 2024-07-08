package com.esenyurt.service;

import com.esenyurt.entity.Person;
import com.esenyurt.view.PersonView;

import java.util.List;

public interface PersonViewService {
    List<PersonView> findByName(String name);
    List<PersonView> findByFullName(String fullName);
}
