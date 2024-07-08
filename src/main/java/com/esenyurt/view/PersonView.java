package com.esenyurt.view;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "[vw_gen_person]")
public class PersonView {

    @Id
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_code")
    private String code;
    @Column(name = "person_name")
    private String name;

    @Column(name = "person_last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "id_number")
    private Long idNumber;

    @Column(name = "date_birthday")
    private Date dateBirthday;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
