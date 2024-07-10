package com.esenyurt.repository;

import com.esenyurt.entity.Person;
import com.esenyurt.view.PersonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonViewRepository extends JpaRepository<PersonView,Long> {
    @Query(value = "select v from PersonView v where upper(v.name) like concat('%', upper(?1) ,'%')")
    List<PersonView> findByName(String name);
    @Query(value = "select v from PersonView v where upper(v.fullName) like concat('%', upper(?1) ,'%')")
    List<PersonView> findByFullName(String fullName);
}
