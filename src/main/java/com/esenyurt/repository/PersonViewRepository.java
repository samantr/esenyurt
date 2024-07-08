package com.esenyurt.repository;

import com.esenyurt.entity.Person;
import com.esenyurt.view.PersonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonViewRepository extends JpaRepository<PersonView,Long> {
    @Query(value = "select * from vw_gen_person v where upper(v.person_name) like '%'+ upper(?1) +'%'",nativeQuery = true)
    List<PersonView> findByName(String name);
    @Query(value = "select * from vw_gen_person v where upper(v.full_name) like '%'+ upper(?1) +'%'",nativeQuery = true)
    List<PersonView> findByFullName(String fullName);
}
